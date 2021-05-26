<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductDiscountCalculator</title>
</head>
<body>
<form action="/display-discount" method="post">
    <h2>Result</h2>
    <p>product description</p>
    <p>Description of product: ${productDes}</p>
    <p>discount amount</p>
    <p>discount amount: ${discountAmount}</p>
    <p>discount price</p>
    <p>discount price: ${discountPrice}</p>
</form>

</body>
</html>