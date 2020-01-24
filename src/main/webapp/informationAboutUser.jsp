<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <%@ page contentType="text/html;charset=UTF-8"  language="java" %>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/table.css">
    <!-- Bootstrap CSS -->

    <title>Дані про користувача</title>
</head>
<body>
<form method="post" action="informationAboutUserServlet">
<div class="container">


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
</div>





<table>
    <tr>
        <th>ПІБ</th>
        <th>Номер карти</th>
        <th>Баланс UAN</th>
        <th>Баланс USD</th>
        <th>Баланс EUR</th>
    </tr>

    <tr>
        <td>${requestScope.user.pib}</td>
        <td>${requestScope.user.account.card}</td>
        <td>${requestScope.user.account.walletUan}</td>
        <td>${requestScope.user.account.walletUsd}</td>
        <td>${requestScope.user.account.walletEur}</td>
    </tr>
</table>

    <div class="row">
        <a  href="index.html" role="button">На головну</a>
    </div>
</form>
</body>
</html>