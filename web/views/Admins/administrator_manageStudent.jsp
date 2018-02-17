
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<div class="container">
    <div class="container">
        <div class="content">
            <h3 class="text-capitalize text-center">Users</h3>
            <table class="table table-dark table-bordered">
                <thead>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Category</th>
                <th>Date created</th>
                <th colspan="2" class="text-center">Manage</th>
                </thead>
                <tbody>
                <c:forEach items="${data}" var="item" >
                    <tr>
                        <td>${item.userid}</td>
                        <td>${item.userfname}</td>
                        <td>${item.userlname}</td>
                        <td>${item.usermail}</td>
                        <td>${item.usercategory}</td>
                        <td>${item.last_calibration}</td>
                        <td><a href="/edit?id=${item.id}" class="btn btn-primary">Edit</a></td>
                        <td><a href="/delete?id=${item.id}" class="btn btn-primary">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div>
                <p>${message}</p>
            </div>
        </div>
    </div>

</body>
</html>
