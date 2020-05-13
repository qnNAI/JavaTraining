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

    <link rel="stylesheet" type="text/css" href="css/main.css"/>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
</head>
<body>
<c:url value="/registration.html" var="registrationPage"/>
<c:url var="mainPage" value="/main.html"/>
<c:url var="orderPage" value="/order.html"/>
<c:url var="infoPage" value="/info.html"/>
<c:url var="deliveryPage" value="/delivery.html"/>
<c:url var="loginPage" value="/login.html"/>
<c:url var="logoutPage" value="/logout.html"/>
<c:url var="basketPage" value="/basket.html"/>
<c:url var="profilePage" value="/profile.html"/>

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

        <c:choose>
            <c:when test="${not empty authorizedUser}">
                <a class="btn btn-outline-warning my-2 my-sm-0" href="${logoutPage}">
                    <i class="fa fa-sign-out"></i>
                    Выйти
                </a>
                <a class="btn btn-outline-primary my-2 my-sm-0" href="${profilePage}" style="margin-left: 5px">
                    <i class="fa fa-user-circle"></i>
                    Личный кабинет
                </a>
            </c:when>
            <c:otherwise>
                <a class="btn btn-outline-success my-2 my-sm-0"
                   href="${loginPage}">
                    <i class="fa fa-sign-out"></i>
                    Войти
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>

<h2>
    <div style="text-align: center; margin-top: 25px;">Корзина</div>
</h2>

<table>
    <jsp:useBean id="listOfProductList" scope="request" class="java.util.ArrayList"/>
    <c:forEach items="${listOfProductList}" var="productList">
        <tr>
            <td><img src="${productList.product.imagePath}" alt="No image"></td>
            <td>
                <h3>${productList.product.name}</h3>
                <h6>${productList.product.description}</h6>
            </td>
            <td>
                <h5>${productList.finalPrice} р</h5>
                <input type="number" step="1" min="1" max="200" id="productAmount"
                       name="productAmount"
                       value="${productList.amount}" required style="margin-top: auto">
            </td>
            <td>
                <form class="form">
                    <button type="submit" class="btn btn-warning" style="margin-top: auto;">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


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