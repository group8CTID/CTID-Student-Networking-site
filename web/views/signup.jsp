<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="includes/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="assets/bootstrap-dist/css/bootstrap.css">
    <title>User Signup</title>
</head>
<menu>
    <jsp:include page="includes/menu.jsp"/>
</menu>
<body>
<div class="container">
    <div class="content">
        <div class="col-md-6 offset-md-3">
            <div class="row justify-content-center">
                <p class="lead">Register</p>
            </div>
            <div class="card-body">
                <div class="form">
                    <form action="/register" category="form" method="post" class="form">
                        <div class="form-group">
                            <label for="id">ID :</label>
                            <p class="bg-danger">${idErrMsg}</p>
                            <input type="text" class="form-control" name="id" id="id">
                        </div>
                        <div class="form-group">
                            <label for="fName">First Name :</label>
                            <p class="bg-danger">${fNameErrMsg}</p>
                            <input type="text" class="form-control" name="fName" id="fName">
                        </div>
                        <div class="form-group">
                            <label for="lName">Last Name :</label>
                            <p class="bg-danger">${lNameErrMsg}</p>
                            <input type="text" class="form-control" name="lName" id="lName">
                        </div>
                        <div class="form-group">
                            <label for="emailAdress">Email :</label>
                            <p class="bg-danger">${emailAdressErrMsg}</p>
                            <input type="text" class="form-control" name="emailAdress" id="emailAdress">
                        </div>
                        <div class="form-group">
                            <label for="password">Password :</label>
                            <p class="bg-danger">${passwordErrMsg}</p>
                            <input type="password" class="form-control" name="password" id="password">
                        </div>
                        <div class="form-group">
                            <label for="cpassword">Confirm password : </label>
                            <input type="password" class="form-control" name="cpassword" id="cpassword">
                        </div>
                        <div class="form-group">
                            <input type="hidden" id="category" name="category" value="manager">
                        </div>
                        <div>
                            <input type="submit" class="btn btn-block btn-primary" value="Register">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>
