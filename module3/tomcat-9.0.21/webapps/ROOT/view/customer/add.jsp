<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/6/2021
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <style>
        body {
            color: #fff;
            background: #63738a;
            font-family: 'Roboto', sans-serif;
        }
        .form-control{
            height: 40px;
            box-shadow: none;
            color: #969fa4;
        }
        .form-control:focus{
            border-color: #5cb85c;
        }
        .form-control, .btn{
            border-radius: 3px;
        }
        .signup-form{
            width: 400px;
            margin: 0 auto;
            padding: 30px 0;
        }
        .signup-form h2{
            color: #636363;
            margin: 0 0 15px;
            position: relative;
            text-align: center;
        }
        .signup-form h2:before, .signup-form h2:after{
            content: "";
            height: 2px;
            width: 30%;
            background: #d4d4d4;
            position: absolute;
            top: 50%;
            z-index: 2;
        }
        .signup-form h2:before{
            left: 0;
        }
        .signup-form h2:after{
            right: 0;
        }
        .signup-form .hint-text{
            color: #999;
            margin-bottom: 30px;
            text-align: center;
        }
        .signup-form form{
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #f2f3f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .signup-form .form-group{
            margin-bottom: 20px;
        }
        .signup-form input[type="checkbox"]{
            margin-top: 3px;
        }
        .signup-form .btn{
            font-size: 16px;
            font-weight: bold;
            min-width: 140px;
            outline: none !important;
        }
        .signup-form .row div:first-child{
            padding-right: 10px;
        }
        .signup-form .row div:last-child{
            padding-left: 10px;
        }
        .signup-form a{
            color: #fff;
            text-decoration: underline;
        }
        .signup-form a:hover{
            text-decoration: none;
        }
        .signup-form form a{
            color: #5cb85c;
            text-decoration: none;
        }
        .signup-form form a:hover{
            text-decoration: underline;
        }
    </style>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="signup-form">
    <form method="post">
        <h2>ADD</h2>
        <p class="hint-text">Add a new customer</p>
        <div class="form-group">
            <input class="form-control" name="name" placeholder="Name" >
            <p>${msgName}</p>
        </div>
        <%--        <div class="form-group">--%>
        <%--            <input type="type" class="form-control" name="idType" placeholder="Type Customer">--%>
        <%--        </div>--%>
        <div class="form-group">
            <select class="form-select form-control" aria-label="Default select example" name="idType">
                <option selected>Type Customer</option>
                <c:forEach var="typeCustomer" items="${typeCustomerList}">
                    <option value="${typeCustomer.getIdTypeCustomer()}">${typeCustomer.getNameTypeCustomer()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <input  class="form-control" name="dateOfBirth" placeholder="birthday" >
            <p>${msgDateOfBirth}</p>
        </div>
        <%--        <div class="form-group">--%>
        <%--            <input type="gender" class="form-control" name="gender" placeholder="gender" required="required">--%>
        <%--        </div>--%>
        <div class="form-group">
            <select class="form-select form-control" aria-label="Default select example" name="gender">
                <option selected>Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
<%--        <div class="form-group">--%>
<%--            <input class="form-control" name="idCard" placeholder="ID Card" >--%>
<%--            <p>${msgIdCard}</p>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <input class="form-control" name="phone" placeholder="Phone" >--%>
<%--            <p>${msgPhone}</p>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <input class="form-control" name="email" placeholder="Email" >--%>
<%--            <p>${msgEmail}</p>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <input class="form-control" name="address" placeholder="Address" >--%>
<%--        </div>--%>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>

    </form>
    <div class="text-center">Already have an account? <a href="#">Sign in</a></div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
