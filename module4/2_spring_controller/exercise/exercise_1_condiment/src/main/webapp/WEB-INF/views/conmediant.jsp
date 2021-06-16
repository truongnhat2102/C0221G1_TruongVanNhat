<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/16/2021
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>condments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/conmediant" method="post">
    <div>
        <input type="checkbox" value="lettuce" name="spices">
        <a>Lettuce</a>
    </div>
    <div>
        <input type="checkbox" value="tomato" name="spices">
        <a>Tomato</a>
    </div>
    <div>
        <input type="checkbox" value="mustard" name="spices">
        <a>Mustard</a>
    </div>
    <div>
        <input type="checkbox" value="sprouts" name="spices">
        <a>Sprouts</a>
    </div>
    <hr>
    <button type="submit">Save</button>
</form>
<%--<div>--%>
<%--    <c:forEach items="condiments" var="condiment">--%>
<%--        <div>${condiment}</div>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
<div>${message}</div>


</body>
</html>
