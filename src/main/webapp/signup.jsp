<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 10.12.2020
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="<%= request.getContextPath() %>" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" required/></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input type="text" name="surname" required/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" required/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" required/></td>
        </tr>
    </table>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
