<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/28/2021
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>List employee</title>
    <title>Bootstrap User Management Data Table</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            background: #299be4;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn {
            color: #566787;
            float: right;
            font-size: 13px;
            background: #fff;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn:hover, .table-title .btn:focus {
            color: #566787;
            background: #f2f2f2;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.settings {
            color: #2196F3;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .status {
            font-size: 30px;
            margin: 2px 2px 0 0;
            display: inline-block;
            vertical-align: middle;
            line-height: 10px;
        }

        .text-success {
            color: #10c469;
        }

        .text-info {
            color: #62c9e8;
        }

        .text-warning {
            color: #FFC107;
        }

        .text-danger {
            color: #ff5b5b;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
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

        .img {
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
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-5">
                        <h2>Employee <b>Management</b></h2>
                    </div>
                    <div class="col-xs-7">
                        <a href="/employee?action=add" class="btn btn-primary"><i
                                class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Division</th>
                    <th>Action</th>
                </tr>
                </thead>

                <c:forEach var="employee" items="${employees}">
                    <tbody>
                    <tr>
                        <td>${employee.id}</td>
                        <td><a href="/employee?action=detail&id=${employee.id}">${employee.name}</a></td>
                        <td>${employee.position}</td>
                        <td>${employee.division}</td>
                        <td>
                            <button type="button" class="btn btn-primary" class="settings" title="Settings"
                                    data-toggle="tooltip"><a href="/employee?action=edit&id=${employee.id}"><i
                                    style="color: white" class="material-icons">&#xE8B8;</i></a></button>
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#exampleModalLong" onclick="sendDataToModal('${employee.id}')">
                                <a><i style="color: white" class="material-icons">&#xE5C9;</i></a>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>

            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item"><a href="#">Previous</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<form action="/employee?action=delete" method="post">
    <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" id="idName" name="id" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    function sendDataToModal(id) {
        document.getElementById("idName").value = id;
    }
</script>
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