<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/6/2021
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100 h-75" src="/img/53114-furama-resort-da-nang-11.jpg" alt="First slide">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>VILLA</h5>
                            <p>bla bla bla bla</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100 h-75" src="/img/Furama-Resort-Da-Nang16-1280x720.jpg" alt="Second slide">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>HOUSE</h5>
                            <p>ble ble ble ble</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100 h-75" src="/img/unnamed.jpg" alt="Third slide">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>ROOM</h5>
                            <p>blo blo blo blo</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

