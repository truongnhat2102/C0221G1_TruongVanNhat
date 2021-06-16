<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/16/2021
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<h2>Calculate</h2>
<hr>
<form action="/calculate" method="post">
    <div>
        <input type="text" name="num1" placeholder="enter number" value="${number1}">
        <input type="text" name="num2" placeholder="enter number" value="${number2}">
    </div>
    <div>
        <button type="submit" name="sign" value="1">Addition(+)</button>
        <button type="submit" name="sign" value="2">Subtraction(-)</button>
        <button type="submit" name="sign" value="3">Multiplication(*)</button>
        <button type="submit" name="sign" value="4">Division(/)</button>
    </div>
</form>
<div>
    <p>Result: ${result}</p>
</div>
</body>
</html>
