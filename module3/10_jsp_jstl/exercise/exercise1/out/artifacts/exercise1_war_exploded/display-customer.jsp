<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/27/2021
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <table>
        <tr>
            <td>name</td>
            <td>date of birth</td>
            <td>address</td>
            <td>img</td>
        </tr>
        <c:forEach items="${customers}" varStatus="index" var="customer">
            <tr>
                <td><c:out value="${customer.getName()}"></c:out></td>
                <td><c:out value="${customer.getDateOfBirth()}"></c:out></td>
                <td><c:out value="${customer.getAddress()}"></c:out></td>
                <td><c:out value="${customer.getAvatar()}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
