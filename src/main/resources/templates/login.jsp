<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head lang="ru">
    <meta charset="UTF-8">
    <title>Log In</title>
</head>
<body>

<c:if test="$(not empty error)">
    $(error)
</c:if>

<%--<form:form method="post" commandName="user" action="check-user" class="box login">--%>
<form:form name="form-Login" action="j_spring_security_check" method="post">

<div id = "login" class = "container">
    <h1>Log in</h1>
    <div class="form-group">
        <label for="usernamesignin">Your email or username:</label>
        <input type="text" name="username-signin" class="form-control" id="usernamesignin" required="required" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="pwd">Your password:</label>
        <input type="password" name="password-signin" class="form-control" id="pwd" required="required" placeholder="Password">
    </div>
    <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</div>

</form:form>
</body>
</html>
