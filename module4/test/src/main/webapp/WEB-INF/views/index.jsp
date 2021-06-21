<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/20/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8"/>
  <title>Spring Boot Thymeleaf Application - Bootstrap Modal</title>

  <link th:rel="stylesheet" th:href="@{/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css} "/>
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
  <div class="container">
    <a class="navbar-brand" href="/">Thymeleaf - Bootstrap Modal</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
            aria-controls="navbarResponsive"
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Services</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <div class="row mt-5">
    <div class="col">
      <!-- Button trigger modal -->
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Launch simple modal
      </button>

      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal1">
        Dynamic modal 1
      </button>

      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2">
        Dynamic modal 2
      </button>

      <th:block th:replace="_modals :: modal('exampleModal')">modal</th:block>
      <th:block th:replace="_modals :: modal('exampleModal1')">modal</th:block>
      <th:block th:replace="_modals :: modal('exampleModal2')">modal</th:block>
    </div>
  </div>
</div>


<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>

<script>
  $('#exampleModal1').on('show.bs.modal', function () {
    $.get("/modals/modal1", function (data) {
      $('#exampleModal1').find('.modal-body').html(data);
    })
  });

  $('#exampleModal2').on('show.bs.modal', function () {
    var name = prompt("Please enter your name", "John Doe");
    $.get("/modals/modal2?name=" + name, function (data) {
      $('#exampleModal2').find('.modal-body').html(data);
    })
  })
</script>

</body>
</html>