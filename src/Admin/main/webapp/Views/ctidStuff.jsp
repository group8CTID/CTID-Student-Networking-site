<%@ page errorPage = "error.jsp" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
    <title>CTID Posts</title>
    <link rel = "stylesheet" href = "style1.css" type = "text/css"> </link>
</head>
<body>
<sql:setDataSource
        var = "myDS"
      driver = "com.mysql.jdbc.Driver"
      url = "jdbc:mysql://127.0.0.1:3306/ctidstudents"
      user = "root"
      password=""
 />

<sql:query var="listStuff" dataSource = "${myDS}">
    SELECT * FROM `ctidposts` ORDER BY `postId`
</sql:query>

<p>
    <center><h3>CTID Students Posts</h3></center>
</p>
<div align="center">
    <p><a href="${pageContext.request.contextPath}createPost.jsp">Create a new product</a></p>
    <table class="products" border="1" cellpadding="5">
        <tr>
            <th>POST ID</th>
            <th>POST LOCATION</th>
            <th>POST CATEGORY</th>
            <th>POST VIEWS</th>
            <th COLSPAN="3">POST CONTROLS</th>
        </tr>
    <c:forEach var = "item" items = "${listStuff.rows}">
            <tr>
                <td class="rght"><c:out value="${item.postId}"/></td>
                <td class="cntr"><c:out value="${item.postLocation}"/></td>
                <td class="cntr"><c:out value="${item.postCategory}"/></td>
                <td class="rght"><c:out value="${item.postViews}"/></td>
                <td><a href = "${pageContext.request.contextPath}show.jsp?id= ${item.postId}">Show</a></td>
                <td><a href = "${pageContext.request.contextPath}edit.jsp?id= ${item.postId}">Edit</a></td>
                <td><a href = "${pageContext.request.contextPath}delete.jsp?id= ${item.postId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
