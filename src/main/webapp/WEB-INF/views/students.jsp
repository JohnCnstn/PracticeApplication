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
    <link rel="stylesheet" href="<c:url value="/resources/css/slideMenu/BootSlideMenu.css"/>">

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.tablesorter.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.tablesorter.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/createPractice.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/getAllStudentsId.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/slideMenu/BootSlideMenu.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    <script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
    <script>
        webshims.setOptions('waitReady', false);
        webshims.setOptions('forms-ext', {types: 'date'});
        webshims.polyfill('forms forms-ext');
    </script>

    <script>
        jQuery(document).ready(function($) {
            $(".clickable-row").click(function() {
                window.location = $(this).data("href");
            });
        });
    </script>>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#test').BootSideMenu({
                side: "left"
            });
        });
    </script>

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

    <form:form name="form-Customer" commandName="practiceDto" action="sign-up" method="POST" id="customerForm">

    <div class="form-group" id="wrapper">

        <table class="tablesorter" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
                <tr>
                    <th></th>
                    <th><span>First Name</span></th>
                    <th><span>Second Name</span></th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${listOfStudents}" var="i">
                    <tr>
                        <td><input type="checkbox" id="studentId" checked="" name="${i.id}"/></td>
                        <td class='clickable-row' data-href="/head-master/userInfo/${i.id}">${i.firstName}</td>
                        <td>${i.lastName}</td>
                        <td>
                            <sec:authorize access="hasRole('HEAD_MASTER')">

                                <spring:url value="/head-master/userInfo/${i.id}" var="userProfileUrl" />

                                <button class="btn btn-info"
                                        onclick="location.href='${userProfileUrl}'">Info</button>

                            </sec:authorize>

                            <sec:authorize access="hasRole('ADMIN')">

                                <spring:url value="/admin/userInfo/${i.id}" var="userProfileUrl" />

                                <button class="btn btn-info"
                                        onclick="location.href='${userProfileUrl}'">Info</button>

                            </sec:authorize>

                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </div>

        <sec:authorize access="hasRole('ADMIN')">

            <div id="test">
                <div class="user">
                </div>

                <div class="list-group">

                    <a href="#" class="list-group-item">Item 1</a>
                    <a href="#" class="list-group-item">Item 2</a>
                    <a href="#" class="list-group-item">Item 3</a>
                    <a href="#" class="list-group-item">Item 4</a>

                </div>

            </div>

        </sec:authorize>

    <sec:authorize access="hasRole('HEAD_MASTER')">

    <div class="container">

        <!-- Trigger the modal with a button -->
        <button id="getAllStudentsId" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create Practice</button>

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

                            <div id = "create_practice">

                                <div class="form-group">

                                    <div class="form-group has-feedback">
                                        <div class="form-group">
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <form:label path="startDate" for="startDate">Start date of practice:</form:label>
                                                <form:input path="startDate" type="date" name="startDate" class="form-control" id="startDate" required="required" placeholder="18:12:1997"/>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="form-group">

                                    <div class="form-group has-feedback">
                                        <div class="form-group">
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <form:label path="endDate" for="endDate">End date of practice:</form:label>
                                                <form:input path="endDate" type="date" name="endDate" class="form-control" id="endDate" required="required"/>>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="sign-up button">
                                    <input type="submit" value="Sign up" />
                                </div>

                            </div>

                    </div>

                    <div class="modal-footer">
                        <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                        <div class="col-sm-7" id="postResultDiv"></div>
                    </div>

                </div>

            </div>
        </div>



    </div>

    </sec:authorize>

    </form:form>

</body>
</html>
