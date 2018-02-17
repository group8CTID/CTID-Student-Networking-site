
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
    <jsp:include page="includes/header.jsp"/>
</head>
<body>
<div class="container">
    <div class="content">
        <div class="card">
            <div class="card-header">
                <p class="lead">Equipments</p>
            </div>
            <div class="card-body">
                <div class="table">
                    <table class="table">
                        <thead>
                        <tr>
                            <td>Post Id</td>
                            <td>Post Name</td>
                            <td>Post Category</td>
                            <td>Post Subcategory</td>
                            <td>Post Location</td>
                            <td>Post Image</td>
                            <td>Post Date</td>
                            <td>Action</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="items" items="post" >
                            <tr>
                                <td>${item.post_id}</td>
                                <td>${item.post_name}</td>
                                <td>${item.post_category}</td>
                                <td>${item.sub_category}</td>
                                <td>${item.post_location}</td>
                                <td>${item.post_image}</td>
                                <td>${item.post_date}</td>
                                <td><a href="/book?id=${item.id}" class="btn btn-primary">Book</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>
