<%@ page import="beans.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 10.12.2020
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reader Page</title>
</head>
<body>
    <form action="mainReader" method="POST">
        <input type="text" placeholder="book name" name="name" />
        <br><br><input type="submit" value="search" />
    </form>

    <c:forEach items="${list}" var = "book">
        <h2>${book.getName()}</h2>
        <h4>${book.getAuthor()}</h4>
        <p>${book.getDescription()}</p>
        <br>
        <p>${book.getPages()}</p>
        <form action="mainReader" method="POST">
            <br><br><input type="submit" value= ${book.getName()} name="book" />
        </form>
        <hr>
    </c:forEach>
</body>
</html>
