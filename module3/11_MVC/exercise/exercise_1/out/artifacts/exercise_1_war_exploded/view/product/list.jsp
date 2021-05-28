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
    <title>LIST PRODUCT</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>LIST PRODUCT</h1>

<a href="/product?action=add">Add new product</a>
<form method="post">
    <input type="text" name="find">
    <a href="/product?action=find">Find product</a>
</form>

<form method="post">
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>DESCRIPTION</th>
            <th>MANUFACTURE</th>
        </tr>
        <c:forEach var="product" items='${products}'>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.manufacture}</td>
                <td><a href="/product?action=edit&id=${product.getId()}">Edit</a></td>
                <td><a href="/product?action=delete&id=${product.getId()}">Delete</a></td>
                <td><a href="/product?action=detail&id=${product.getId()}">Detail</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>