<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/28/2021
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <title>Bootstrap Simple Registration Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css">
    <script src="lib/jquery/jquery-3.6.0.min.js"></script>
    <script src="lib/js/bootstrap.min.js"></script>
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
        .form-control {
            box-shadow: none;
            border-radius: 4px;
        }

        .form-control:focus {
            border-color: #f08373;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        }

        .navbar {
            background: #fff;
            padding-left: 16px;
            padding-right: 16px;
            border-bottom: 1px solid #dfe3e8;
            border-radius: 0;
        }

        .navbar .navbar-brand, .navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
            padding-left: 0;
            font-size: 20px;
            padding-right: 50px;
        }

        .navbar .navbar-brand b {
            font-weight: bold;
            color: green;
        }

        .navbar ul.nav li a {
            color: #888;
        }

        .navbar ul.nav li a:hover, .navbar ul.nav li a:focus {
            color: #f08373 !important;
        }

        .navbar ul.nav li.active > a, .navbar ul.nav li.open > a {
            color: #eb5844 !important;
            background: transparent !important;
        }

        .search-box {
            width: 100%;
            position: relative;
        }

        .search-box input {
            border-color: #dfe3e8;
            box-shadow: none
        }

        .search-box input, .search-box .btn {
            min-height: 38px;
            border-radius: 2px;
        }

        .search-box .input-group-btn .btn {
            border-color: #eb5844;
            background: #eb5844;
            outline: none;
        }

        .navbar ul li i {
            font-size: 18px;
            line-height: 16px;
        }

        .navbar .navbar-right .dropdown-toggle::after {
            display: none;
        }

        .navbar .dropdown-menu {
            border-radius: 1px;
            border-color: #e5e5e5;
            box-shadow: 0 2px 8px rgba(0, 0, 0, .05);
        }

        .navbar .dropdown-menu li a {
            padding: 6px 20px;
        }

        .navbar .navbar-right .dropdown-menu {
            width: 400px;
            padding: 20px;
            left: auto;
            right: 0;
            font-size: 14px;
        }

        .hide {
            display: none !important;
        }

        @media (max-width: 768px) {
            .navbar .navbar-right .dropdown-menu {
                width: 100%;
                background: transparent;
                padding: 10px 20px;
            }

            .navbar .input-group {
                width: 100%;
            }
        }

        .footer {
            bottom: 0px;
            position: fixed;
            color: darkgray;
        }
        .img{
            width: 100%;
            height: 700px;
        }
    </style>
    <script>
        $(document).ready(function () {
            var dropdown = $(".navbar-right .dropdown");
            var toogleBtn = $(".navbar-right .dropdown-toggle");

            // Toggle search and close icon for search dropdown
            dropdown.on("show.bs.dropdown", function (e) {
                toogleBtn.toggleClass("hide");
            });
            dropdown.on("hide.bs.dropdown", function (e) {
                toogleBtn.addClass("hide");
                toogleBtn.first().removeClass("hide");
            });
        });
    </script>
</head>
<body>
<div class="headbody">
    <nav class="navbar navbar-default navbar-expand-lg navbar-light">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">Furama<b>Resort</b></a>
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="navbar-toggler-icon"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/customer">Customer</a></li>
                <li><a href="/employee">Employee</a></li>
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">Services <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Web Design</a></li>
                        <li><a href="#">Web Development</a></li>
                        <li><a href="#">Graphic Design</a></li>
                        <li><a href="#">Digital Marketing</a></li>
                    </ul>
                </li>
                <li><a href="/contract">Contract</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="fa fa-search"></i></a>
                    <a data-toggle="dropdown" class="nav-link dropdown-toggle hide" href="#"><i class="fa fa-close"></i></a>
                    <ul class="dropdown-menu">
                        <li>
                            <form>
                                <div class="input-group search-box">
                                    <input type="text" id="search" class="form-control" placeholder="Search here...">
                                    <span class="input-group-btn">
									    <button type="button" class="btn btn-primary"><i
                                                class="fa fa-search"></i></button>
								    </span>
                                </div>
                            </form>
                        </li>
                    </ul>
                </li>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
            </ul>
        </div>
    </nav>
</div>
<div class="signup-form">
    <form method="post">
        <h2>EDIT</h2>
        <p class="hint-text">Edit a <a>${customer.id}</a> customer</p>
        <div class="form-group">
            <input type="name" class="form-control" name="name" placeholder="Name" value="${customer.name}" required="required">
        </div>
        <div class="form-group">
            <input type="number" class="form-control" name="idType" value="${customer.idType}" placeholder="Type Customer">
        </div>
        <div class="form-group">
            <input type="type" class="form-control" name="dateOfBirth" value="${customer.dateOfBirth}" placeholder="birthday" required="required">
        </div>
        <div class="form-group">
            <input type="gender" class="form-control" name="gender" value="${customer.gender}" placeholder="gender" required="required">
        </div>
        <div class="form-group">
            <input class="form-control" name="idCard" placeholder="ID Card" value="${customer.idCard}" required="required">
        </div>
        <div class="form-group">
            <input class="form-control" name="phone" placeholder="Phone" value="${customer.phone}" required="required">
        </div>
        <div class="form-group">
            <input type="email" class="form-control" name="email" placeholder="Email" value="${customer.email}" required="required">
        </div>
        <div class="form-group">
            <input class="form-control" name="address" value="${customer.address}" placeholder="Address" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">FINISH</button>
        </div>
    </form>
</div>
<div class="container-fluid">
    <div class="row ">
        <div class="col-12">
            <div style="width: 100%; height: 60px; margin-top: 5%; text-align: center">
                <p> © 2018 Furama Resort Danang.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>