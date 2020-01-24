<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="java.io.*,java.util.Locale" %>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>
<%@ page import="java.text.DateFormat,java.util.Date" %>
<%@ page import="java.io.*,java.util.Locale" %>
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
<form method="post" action="transaction">
    <div class="container">


        <div class="row">
            <div class="col-25">



                <label for="card">Номер карти (**** **** **** ****)</label>
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
            <th>Карта отримувача</th>
            <th>Карта відправника</th>
            <th>Валюта</th>
            <th>Сума</th>
            <th>Дата</th>
            <th>Час</th>
        </tr>
<c:forEach items="${list}" var="list">
        <tr>
            <td>${list.to}</td>
            <td>${list.from}</td>
            <td>${list.currency}</td>
            <td>${list.amount}</td>
            <td>${list.date}</td>
            <td>${list.time}</td>
        </tr>

</c:forEach>
    </table>
    <div class="row">
        <a  href="index.html" role="button">На головну</a>
    </div>

</form>
</body>
</html>
