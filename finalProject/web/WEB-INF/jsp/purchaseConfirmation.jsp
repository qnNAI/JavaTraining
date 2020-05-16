<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basket</title>

    <script src="https://use.fontawesome.com/0227303a93.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="css/purchaseConf.css"/>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="js/TabContent.js" type="text/javascript"></script>

</head>
<body>
<c:url var="mainPage" value="/main.html"/>
<c:url var="orderPage" value="/order.html"/>
<c:url var="infoPage" value="/info.html"/>
<c:url var="deliveryPage" value="/delivery.html"/>
<c:url var="loginPage" value="/login.html"/>
<c:url var="profilePage" value="/profile.html"/>
<c:url var="logoutPage" value="/logout.html"/>
<c:url var="confirmPurchase" value="/confirmPurchase.html"/>
<c:url var="basketPage" value="/basket.html"/>

<c:set var="authorizedUser" scope="session" value="${sessionScope.authorizedUser}"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${mainPage}" style="color: #1E90FF">WORKSHOP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${infoPage}">О нас</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${deliveryPage}">Доставка</a>
            </li>
            <li class="nav-item active">
                <c:choose>
                    <c:when test="${not empty authorizedUser}">
                        <a class="nav-link" data-toggle="tooltip" data-placement="bottom" title="Создать свой заказ"
                           href="${orderPage}">Заказать</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" data-toggle="tooltip" data-placement="bottom" title="Создать свой заказ"
                           href="${loginPage}">Заказать</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>

        <a class="btn btn-outline-warning my-2 my-sm-0" href="${logoutPage}">
            <i class="fa fa-sign-out"></i>
            Выйти
        </a>
        <a class="btn btn-outline-primary my-2 my-sm-0" href="${profilePage}" style="margin-left: 5px">
            <i class="fa fa-user-circle"></i>
            Личный кабинет
        </a>

    </div>
</nav>
<!-- end nav -->

<jsp:useBean id="amount" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="sum" scope="request" type="java.lang.Double"/>
<jsp:useBean id="localAddresses" scope="request" class="java.util.ArrayList"/>
<div class="container">
    <div class="mt-5">
        <h4>Товаров в заказе: ${amount}</h4>
        <h4>Итого: ${sum} р</h4>
        <br><p>Выберите способ получения: </p>
    </div>
    <!-- Tab links -->
    <div class="tab tab-clazz">
        <button class="tablinks" onclick="openTab(event, 'PICKUP')">Самовывоз</button>
        <button class="tablinks" onclick="openTab(event, 'DELIVERY')">Доставка</button>
    </div>

    <!-- Tab content -->
    <div id="PICKUP" class="tabcontent">
        <br><h5>Выберите наиболее подходящий вариант:</h5>
        <form method="post" action="${confirmPurchase}">
            <input type="hidden" name="method" value="pickup">
            <c:forEach items="${localAddresses}" var="localAddress">
                <p><input type="radio" name="localAddressID" value="${localAddress.id}"> ${localAddress.address}</p>
            </c:forEach>
            <p><input type="submit" value="Оформить заказ" class="btn btn-primary">
                <a class="btn btn-danger" href="${basketPage}">Вернуться в корзину</a></p>
        </form>
    </div>

    <div id="DELIVERY" class="tabcontent">
        <form method="post" action="${confirmPurchase}">
            <input type="hidden" name="method" value="delivery">
            <br><label for="address"><h5>Введите ваш адрес:</h5></label>
            <p><input type="text" id="address" name="address" class="address-input"></p>
            <p><button type="submit" class="btn btn-primary">Оформить заказ</button>
                <a class="btn btn-danger" href="${basketPage}">Вернуться в корзину</a></p>
        </form>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>