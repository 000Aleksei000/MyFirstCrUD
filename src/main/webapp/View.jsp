<%@ page import="Beans.Student" %>
<jsp:useBean id="students" scope="request" type="java.util.List"/>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 3/9/2021
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CrUD</title>
</head>
<body>
<h2>All Students:</h2>
    <p>
        <c:forEach var="student" items="${requestScope.students}">
        <ul>
            <li>Name : <c:out value="${student.name}" /> </li>
            <li>Age : <c:out value="${student.age}" /> </li>
            <form method="post" action="/delete">
                <input type="number" hidden name = "id" value="${student.id}">
                <input type="submit" name="delete" value="Delete">
            </form>
    <form method="get" action="/update">
        <input type="number" hidden name = "id" value="${student.id}">
        <input type="submit" name="update" value="Update">
    </form>
        </ul>
<hr/>
        </c:forEach>
    </p>
<br>
<br>
<h2>Add new Student</h2>
<form method="post" action="/controller">
    <input type="text" name="Name" > Name  <br>
    <input type="number" name="Age"> Age <br>
    <input type="submit" name="Submit"><br>
</form>
</body>
</html>
