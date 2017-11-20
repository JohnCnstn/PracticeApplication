<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${user.userName}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/admin.css"/>">

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.tablesorter.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.tablesorter.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/postrequest.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

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


    <div class="form-group" id="wrapper">

        <table class="tablesorter" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
                <tr>
                    <th><span>First Name</span></th>
                    <th><span>Second Name</span></th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${listOfStudents}" var="i">
                    <tr>
                        <td>${i.firstName}</td>
                        <td>${i.lastName}</td>
                        <td>

                            <sec:authorize access="hasRole('ADMIN')">

                                <spring:url value="/admin/userInfo/${i.id}" var="userProfileUrl" />

                                <spring:url value="/admin/delete/${i.id}" var="deleteUserUrl" />

                                    <button class="btn btn-danger"
                                            onclick="location.href='${deleteUserUrl}'">Delete</button>
                            </sec:authorize>

                            <sec:authorize access="hasRole('HEAD_MASTER')">

                                <spring:url value="/head-master/userInfo/${i.id}" var="userProfileUrl" />

                            </sec:authorize>

                            <button class="btn btn-info"
                                    onclick="location.href='${userProfileUrl}'">Info</button>

                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </div>

    <div class="container">
        
        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Create practice</h4>
                    </div>
                    <div class="modal-body">

                        <form:form name="form-Customer" commandName="practiceDto" action="sign-up" method="POST" id="customerForm">

                            <div id = "create_practice">

                                <div class="form-group">
                                    <form:label path="startDate" for="startDate">Start date of practice:</form:label>
                                    <form:input path="startDate" type="text" name="startDate" class="form-control" id="startDate" required="required" placeholder="18:12:1997"/>
                                </div>

                                <div class="form-group">
                                    <form:label path="endDate" for="endDate">End date of practice:</form:label>
                                    <form:input path="endDate" type="text" name="endDate" class="form-control" id="endDate" required="required"/>
                                </div>

                                <div class="sign-up button">
                                    <input type="submit" value="Sign up" />
                                </div>

                            </div>

                        </form:form>

                    </div>

                    <div class="modal-footer">
                        <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                        <div class="col-sm-7" id="postResultDiv"></div>
                    </div>

                </div>

            </div>
        </div>

    </div>

</body>
</html>
