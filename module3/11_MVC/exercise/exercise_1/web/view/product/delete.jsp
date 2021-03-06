<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/28/2021
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Edit product</h1>
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
                <td><input disabled type="text" value="${product.id}" name="id" placeholder="enter id"></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input disabled type="text" name="name" value="${product.name}" placeholder="enter name"></td>
            </tr>
            <tr>
                <td>price</td>
                <td><input disabled type="text"  value="${product.price}" name="price" placeholder="enter price"></td>
            </tr>
            <tr>
                <td>description</td>
                <td><input disabled type="text"  value="${product.description}" name="description" placeholder="enter description"></td>
            </tr>
            <tr>
                <td>manufacture</td>
                <td><input disabled type="text"  value="${product.manufacture}" name="manufacture" placeholder="enter manufacture"></td>
            </tr>
        </table>
        <p>Do you want to delete</p>
        <button type="submit">SURE</button>
    </fieldset>
</form>
</body>
</html>
