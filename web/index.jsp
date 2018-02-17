<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Login</title>
    <jsp:include page="views/includes/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="views/assets/bootstrap-dist/css/bootstrap.css">
</head>

<menu>
    <jsp:include page="views/includes/menu.jsp"/>
</menu>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 col-sm-offset-3">
            <div style="margin-top: 10px">
                <hr>
                <div class="panel panel-primary">
                    <div class="panel-body">


                        <form action="/login" class="form" method="post">
                            <div class="form-group">

                                <input type="text" class="form-control" name="email"
                                       placeholder="Enter Your Email Address">
                            </div>
                            <div class="form-group">

                                <input type="password" class="form-control" name="password"
                                       placeholder="Enter Password">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">
                                    <i class="glyphicon glyphicon-lock"></i>
                                    &nbsp;
                                    Login
                                </button>
                            </div>
                            <br>
                            <p>If you don't have account <a href="/views/signup.jsp"
                                                            class="badge badge-primary">Register</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="views/includes/footer.jsp"/>
</body>
</html>


