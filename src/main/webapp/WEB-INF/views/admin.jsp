<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Practice application</a>
            </div>

            <form:form action="logout" method="get">
                <button type="submit" class="btn navbar-btn navbar-right" id="header-btn">
                    Logout
                </button>
            </form:form>

        </div>
    </div>


    <div class="form-group">

            <table align="center">
                <c:forEach items="${list}" var="i">
                    <tr><td><label>${i.firstName} ${i.lastName}</label></td></tr>
                </c:forEach>
            </table>

    </div>

</body>
</html>
