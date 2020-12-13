<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 10.12.2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<form action="addBook.jsp" method="POST">
    <h2>Write book info</h2>
    <input type="text" placeholder="title" name="title" />
    <br><br>
    <input type="text" placeholder="author" name="author" />
    <br><br>
    <input type="text" placeholder="pages" name="pages" />
    <br><br>
    <input type="text" placeholder="publisher" name="publisher" />
    <br><br>
    <input type="text" placeholder="count" name="count" />
    <br><br><input type="submit" value="insert" />
</form>
</body>
</html>