<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.01.2020
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>

<form method="get" action="sendMoneyToAnotherCard">
<div class="container">

        <div class="row">
            <div class="col-25">
                <label for="yourCard">Ваша карта</label>
            </div>
            <div class="col-75">
                <input type="text" id="yourCard" name="yourCard" placeholder="Your card..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="anotherCard">Карта отримувача</label>
            </div>
            <div class="col-75">
                <input type="text" id="anotherCard" name="anotherCard" placeholder="another card..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="amount">Кількість </label>
            </div>
            <div class="col-75">
                <input type="text" id="amount" name="amount" placeholder="Amount..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="currency">Валюта :</label>
            </div>
            <div class="col-75">
                <select id="currency" name="currency">
                    <option value="uan">Гривня</option>
                    <option value="usd">Долар</option>
                    <option value="eur">Євро</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">

                <input type="submit" value="Submit">
            </div>

</div>
</div>
    <p><%=request.getAttribute("s")%><p>
    <div class="row">
        <a  href="index.html" role="button">На головну</a>
    </div>
</form>
</body>
</html>
