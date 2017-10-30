<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>User page</title>
</head>
<body>
    <h1>Hi ${user}</h1>
    <a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
