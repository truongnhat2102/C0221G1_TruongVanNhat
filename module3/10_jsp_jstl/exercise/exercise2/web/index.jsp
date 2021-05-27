<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 5/27/2021
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css">
    <script src="lib/jquery/jquery-3.6.0.min.js"></script>
    <script src="lib/js/bootstrap.min.js"></script>
  </head>
  <body>
  <form action="/calculate" method="post">
    <h1>SIMPLE CALCULATOR</h1>
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-6">
              <p>First operand:</p>
            </div>
            <div class="col-lg-6">
              <input type="text" name="firstOperand">
            </div>
          </div>
          <div class="row">
            <div class="col-lg-6">
              <p>Operator:</p>
            </div>
            <div class="col-lg-6">
              <input type="text" name="operator">
            </div>
          </div>
          <div class="row">
            <div class="col-lg-6">
              <p>Second operand:</p>
            </div>
            <div class="col-lg-6">
              <input type="text" name="secondOperand">
            </div>
          </div>
          <div class="row">
            <div class="col-12">
              <button type="submit" class="button btn-outline-info" >calculate</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
  </body>
</html>
