<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/26/2021
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    PrintWriter writer = response.getWriter();
    writer.println("<html>");

    Date today = new Date();

    writer.println("<h1>" + today + "</h1>");
    writer.println("</html>");
  %>
  </body>
</html>
