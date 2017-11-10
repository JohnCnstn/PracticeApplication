<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
    <h1>Hi Admin!</h1>
    <a href="logout">logout</a>


    <div class="form-group">
        <label>Students:</label>

        <select name="student">

            <c:forEach items="${list}" var="i">
                <option value="${i.firstName}">${i.firstName}</option>
            </c:forEach>
        </select>

    </div>

</body>
</html>
