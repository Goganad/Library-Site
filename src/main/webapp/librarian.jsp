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
    <title>Librarian Page</title>
</head>
<body>
    <form action="librarian.jsp" method="POST">
        <br><input type="submit" value="addBook" name="addBook" />
    </form>
    <c:forEach items="${books}" var = "book">
        <h2>${book.title}</h2>
        <p>${book.author}</p>
        <p>${book.publisher}</p>
        <p>${book.pages}</p>
    <form action="librarian.jsp" method="POST">
        <br><input type="submit" value= ${book.title} name="deleteBook" />
    </form>
    <hr>
    </c:forEach>
</body>
</html>
