<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/28/2021
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Add new product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>id</td>
                <td><input type="text" name="id" placeholder="enter id"></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" placeholder="enter name"></td>
            </tr>
            <tr>
                <td>price</td>
                <td><input type="text" name="price" placeholder="enter price"></td>
            </tr>
            <tr>
                <td>description</td>
                <td><input type="text" name="description" placeholder="enter description"></td>
            </tr>
            <tr>
                <td>manufacture</td>
                <td><input type="text" name="manufacture" placeholder="enter manufacture"></td>
            </tr>
        </table>
        <button type="submit">ADD</button>
    </fieldset>
</form>
</body>
</html>