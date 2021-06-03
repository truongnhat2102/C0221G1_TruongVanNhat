<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/30/2021
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css">
    <script src="lib/jquery/jquery-3.6.0.min.js"></script>
    <script src="lib/js/bootstrap.min.js"></script>
    <style>
        .headbody {
            font-family: 'Varela Round', sans-serif;
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
<form action="/home"></form>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <img src="../../img/logo.png">
        </div>
        <div class="col-sm-9">
        </div>
    </div>
</div>
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
<div class="container">
    <div class="row">
        <div class="col-12">
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item">
                        <img class="img" src="../../img/Furama-Resort-Da-Nang16-1280x720.jpg" class="d-block w-100">
                    </div>
                    <div class="carousel-item">
                        <img class="img" src="../../img/53114-furama-resort-da-nang-11.jpg" class="d-block w-100">
                    </div>
                    <div class="carousel-item active">
                        <img class="img" src="../../img/unnamed.jpg" class="d-block w-100">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
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