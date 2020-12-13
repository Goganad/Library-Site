<%@ page import="beans.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 10.12.2020
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reader Orders</title>
</head>
<body>
    <h1>Booked books</h1>
        <c:forEach items="${list}" var = "order">
            <h2>${order.idBook}</h2>
            <p>${order.type}</p>
            <p>${order.state}</p>
            <form action="mainReader" method="POST">
                <br><br><input type="submit" value= ${order.idUser} name="remove" />
            </form>
            <hr>
        </c:forEach>
</body>
</html>
