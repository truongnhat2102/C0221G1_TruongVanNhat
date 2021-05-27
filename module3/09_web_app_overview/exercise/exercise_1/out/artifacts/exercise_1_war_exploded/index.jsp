<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/26/2021
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>ProductDiscountCalculator</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form action="/calculate" method="post">
  <h2>Product Discount Calculator</h2>
  <p>Enter product description</p>
  <input type="text" name="productDes" placeholder="Products Description">

  <p>Enter list price</p>
  <input type="text" name="price" placeholder="List Price">

  <p>Enter discount percent</p>
  <input type="text" name="percent" placeholder="Discount Percent">

  <button type="submit">Submit</button>
</form>

</body>
</html>