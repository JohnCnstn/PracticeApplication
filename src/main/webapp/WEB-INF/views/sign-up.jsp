<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log in</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/registration.css">
</head>

<body>

<c:if test="${not empty error}">
    ${error}
</c:if>

    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Practice application</a>
            </div>

            <form:form action="login" method="get">
                <button type="submit" class="btn navbar-btn navbar-right" id="btn-sign-up">
                    Log in
                </button>
            </form:form>

        </div>
    </div>

    <form:form name="form-Login" action="login" method="post">

    <div class="container">
        <div class="form">
            <div col-lg-4 col-lg-offset-8>
                <div id = "login">

                    <h1>Sign up</h1>
                    <div class="form-group">
                        <label for="username-signup">Your username:</label>
                        <input type="text" name="username-signup" class="form-control" id="username-signup" required="required" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="email">Your email:</label>
                        <input type="text" name="email" class="form-control" id="email" required="required" placeholder="email">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Your password:</label>
                        <input type="password" name="password-signin" class="form-control" id="pwd" required="required" placeholder="Password">
                    </div>

                    <div class="check-box">
                        <div class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Keep me logged in</label>
                        </div>
                    </div>

                    <div class="sign-up button">
                        <input type="submit" value="Sign up" />
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div id="f">
        <div class="container">
            <div class="row centered">
                <div col-lg-10 col-lg-offset-1>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-vk"></i></a>
                </div>
            </div>
        </div>
    </div>

</form:form>
</body>
<%--</body>--%>
</html>
