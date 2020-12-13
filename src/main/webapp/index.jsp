<%@ page import="beans.User" %><%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 10.12.2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("user");
%>
<html>
<head>
    <title>Library System</title>
</head>
<body>
<h1>Welcome! Choose option</h1>
<%
    if (user == null) {
        out.print("<p>\n" +
                "        <a href=\"signin\">Sign In</a>\n" +
                "    </p>\n" +
                "    <p>\n" +
                "        <a href=\"signup\">Sign Up</a>\n" +
                "    </p>");
    }
%>
</body>
</html>
