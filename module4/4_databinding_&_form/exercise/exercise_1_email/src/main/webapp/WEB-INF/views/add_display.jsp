<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>ADD</title>
</head>
<body>
<form action="/add_display" method="post">
    <table>
        <tr>
            <td>Language</td>
            <td>
                <select name="language">
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
            <td><input type="checkbox" name="spamFilter"></td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><input type="text" name="signature"></td>
        </tr>
    </table>
    <button type="submit">create display</button>
</form>
</body>
</html>
