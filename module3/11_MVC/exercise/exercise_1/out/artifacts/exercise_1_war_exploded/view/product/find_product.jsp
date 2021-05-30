<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/28/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PRODUCT FOUND OUT</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>PRODUCT FOUND OUT</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>DESCRIPTION</th>
            <th>MANUFACTURE</th>
        </tr>
<%--        <c:forEach var="product" items="${products}">--%>
<%--            <tr>--%>
<%--                <td>${product.id}</td>--%>
<%--                <td>${product.name}</td>--%>
<%--                <td>${product.price}</td>--%>
<%--                <td>${product.description}</td>--%>
<%--                <td>${product.manufacture}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
    </table>
</body>
</html>
