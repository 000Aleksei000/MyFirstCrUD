<%@ page import="Beans.Student" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 3/9/2021
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
Name : ${solostudent.name} <br>
Age  : ${solostudent.age}
<form method="post" action="/update">
    <input type="number" hidden name = "id" value="${solostudent.id}">
   New name : <input type="text" name="newName">
    <input type="submit" name="update" value="Update">
</form>
</body>
</html>
