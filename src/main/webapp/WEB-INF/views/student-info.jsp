<%--
  Created by IntelliJ IDEA.
  User: cryst
  Date: 19.11.2017
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${student.userName}</h1>
    <h1>${student.firstName}</h1>
    <h1>${student.email}</h1>
    <h1>${student.faculty.name}</h1>
    <h1>${student.faculty.university.name}</h1>
    <h1>${student.practice.start_date}</h1>
</body>
</html>