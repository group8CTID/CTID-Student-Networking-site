<%@ page errorPage = "error.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Posts</title>
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
    <fieldset><legend class = "legend">Edit Post</legend>
        <form action = "dataVerifier" method = "post">
            <table>
                <tbody>
                <tr style = "background: white;}">
                    <td><label for = "id">Id:</label></td><td>
                    <input id = "id" name = "id"
                           value = '${param.id}'
                           type = "text"
                           readonly/></td>
                </tr>
                <tr style="background: white;}">
                    <td><label for = "postLocation">Location:</label></td><td>
                    <input id = "postLocation" name = "postLocation"
                           value = '${listStuff.rows[0].postLocation}'
                           type = "text"
                           minlength = "8"
                           required/></td>
                </tr>
                <tr style="background: white;}">
                    <td><label for = "postCategory">Category:</label></td><td>
                    <input id = "postCategory" name = "postCategory"
                           value = "${listStuff.rows[0].postCategory}"
                           type = "text"
                           minlength = "8"
                           required/></td>
                </tr>
                <tr style = "background: white;}">
                    <td><label for = "postViews">Views:</label></td><td>
                    <input id = "postViews" name = "postViews"
                           value = "${listStuff.rows[0].postViews}"
                           type = "number"
                           readonly/></td>
                </tr>
                </tbody>
            </table>

        </form>
        <p><input type = "submit" value = " Save edits "/></p>
        <p><a href="${pageContext.request.contextPath}ctidStuff.jsp">Back</a></p>
    </fieldset>
</div>
</body>
</html>
