<%@ page errorPage = "error.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Details</title>
    <link rel = "stylesheet" href = "style1.css" type = "text/css"> </link>
</head>
<body>
<sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://127.0.0.1:3306/ctidstudents"
        user="root"
        password=""
/>

<sql:query var = "listStuff" dataSource = "${myDS}">
    SELECT * FROM `ctidposts` where postId = ${param.id};
</sql:query>

<div>
    <fieldset>
        <legend class="legend">Display Post</legend>
        <table>
            <tbody>
            <tr style = "background: white;}">
                <td><label for = "id">Id:</label></td>
                <td><input id = "id" name = "id"
                           style = "border:none;font-size:16px;"
                           value = "${param.id}"
                           type = "text"
                           readonly/></td>
            </tr>
            <tr style="background: white;}">
                <td><label for = "postLocation">Location:</label></td>
                <td><input id = "postLocation" name = "postLocation"
                                style = "border:none;font-size:16px;"
                                value = "${listStuff.rows[0].postLocation}"
                                type = "text"
                                readonly/></td>
            </tr>
            <tr style="background: white;}">
                <td><label for = "postCategory">Category:</label></td>
                <td><input id = "postCategory" name = "postCategory"
                           style = "border:none;font-size:16px;"
                           value = "${listStuff.rows[0].postCategory}"
                           type = "text"
                           readonly/></td>
            </tr>

            <tr style="background: white;}">
                <td><label for = "postViews">Views:</label></td>
                <td><input id = "postViews" name = "postViews"
                           style = "border:none;font-size:16px;"
                           value = "${listStuff.rows[0].postViews}"
                           type = "number"
                           readonly/></td>
            </tr>
            </tbody>
        </table>
        <p><a href="${pageContext.request.contextPath}ctidStuff.jsp">Back</a>&nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}edit.jsp?id=${param.id}">Edit</a></p>
    </fieldset>
</div>

</body>
</html>
