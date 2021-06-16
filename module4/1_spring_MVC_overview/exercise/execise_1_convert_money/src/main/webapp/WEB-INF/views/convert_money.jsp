<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/15/2021
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Convert Money</h2>
<form action="/convert_money" method="post">
    <input type="text" name="moneyConvert" placeholder="enter money to convert"/>
    <select name="currency">
        <option value="1">Vietnam -> USD</option>
        <option value="2">USD -> Vietnam</option>
    </select>
    <button type="submit">convert</button>
    <p>Result: ${result}</p>
</form>
</body>
</html>
