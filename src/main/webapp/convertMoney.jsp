<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.01.2020
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>

<form action="convertMoney" method="get">
<div class="container">

        <div class="row">
            <div class="col-25">
                <label for="card">Номер карти</label>
            </div>
            <div class="col-75">
                <input type="text" id="card" name="card" placeholder="Card..">
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
                <label for="from">З якої валюти хочете перевести</label>
            </div>
            <div class="col-75">
                <select id="from" name="from">
                    <option value="uan">Гривня</option>
                    <option value="usd">Долар</option>
                    <option value="eur">Євро</option>
                </select>
            </div>
        </div>
        <div class="row">

            <div class="col-25">
                <label for="to">На яку валюту хочете перевести</label>
            </div>
            <div class="col-75">
                <select id="to" name="to">
                    <option value="uan">Гривня</option>
                    <option value="usd">Долар</option>
                    <option value="eur">Євро</option>
                </select>
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Submit">
        </div>

</div>
    <p><%=request.getAttribute("s")%><p>
        <a  href="index.html" role="button">На головну</a>

</form>
</body>
</html>
</body>
</html>
