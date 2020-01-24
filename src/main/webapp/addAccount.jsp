<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.01.2020
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="style/style.css">
</head>
<body>

<form  method="get"  action="addUserAccount">
<div class="container">

        <div class="row">
            <div class="col-25">
                <label for="pib">ПІБ</label>
            </div>
            <div class="col-75">
                <input type="text" id="pib" name="pib" placeholder="Your name..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="phone">Телефон</label>
            </div>
            <div class="col-75">
                <input type="text" id="phone" name="phone" placeholder="Your phone..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="mail">Електронна пошта</label>
            </div>
            <div class="col-75">
                <input type="text" id="mail" name="mail" placeholder="Your email..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">



                <label for="card">Номер карти</label>
            </div>
            <div class="col-75">
                <input type="text" id="card" name="card" placeholder="Card.." >
            </div>
        </div>
        <div class="row">
            <div class="col-25">

                <div class="row">
                    <input type="submit" value="Submit">
                </div>


</div>

        </div>
    <p><%=request.getAttribute("s")%><p>
    <div class="row">
        <a  href="index.html" role="button">На головну</a>
    </div>
</div>

</form>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>
