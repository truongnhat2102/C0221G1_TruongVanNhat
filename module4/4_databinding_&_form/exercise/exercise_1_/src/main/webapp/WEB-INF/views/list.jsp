<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/17/2021
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<form:form action="/list" method="get" >
    <table>
        <tr>
            <td>#</td>
            <td>language</td>
            <td>page size</td>
            <td>signature</td>
        </tr>
        <c:forEach var="emailDisplay" items="emailDisplayList" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${emailDisplay.language}</td>
                <td>${emailDisplay.pageSize}</td>
                <td>${emailDisplay.signature}</td>
                <td><button href="/action=edit?signature=${emailDisplay.signature}">edit</button></td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>
