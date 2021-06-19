<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/18/2021
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/edit_display" method="post" modelAttribute="emailDisplay">
    <table>
        <tr>
            <td>Language</td>
            <td>
                <select name="language">
                    <option selected value="${emailDisplay.language}"></option>
                    <option value="english">English</option>
                    <option value="vietnamese">VietNamese</option>
                    <option value="Spain">spain</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>Show
                <select name="pageSize">
                    <option selected value="${emailDisplay.pageSize}"></option>
                    <option value="0">0</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    <option value="25">25</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td><input type="checkbox" name="spamFilter" value="${emailDisplay.spamFilter}"></td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><input type="text" name="signature" value="${emailDisplay.signature}"></td>
        </tr>
    </table>
    <button type="submit">save display</button>
</form:form>
</body>
</html>
