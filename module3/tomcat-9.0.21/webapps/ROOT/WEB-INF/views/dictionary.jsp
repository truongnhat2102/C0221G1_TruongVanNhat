<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 6/15/2021
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

</head>
<body>
<h2>DICTIONARY</h2>
<form action="/dictionary" method="post">
    <div class="container">
        <div class="row">
            <div class="col-6">
                <input type="text" class="form-group" name="inputText" placeholder="Enter text here" style="width: 50%; height: 100%"/>
                <select name="language1">
                    <option value="1">Viet Nam</option>
                    <option value="2">English</option>
                </select>
            </div>
            <div class="col-6">
                <p>${outputText}</p>
                <select name="language2">
                    <option value="1">Viet Nam</option>
                    <option value="2">English</option>
                </select>
            </div>
        </div>
        <div class="row"></div>
        <div class="row">
            <div class="col-12">
                <button type="submit">translate</button>
            </div>
        </div>
    </div>
</form>


</body>
</html>
