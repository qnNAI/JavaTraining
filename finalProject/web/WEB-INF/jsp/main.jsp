<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>

    <script src="https://use.fontawesome.com/0227303a93.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="css/font-awesome.min.css">

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
<c:url var="mainPage" value="/main.html"/>
<c:url var="errorPage" value="/error.html"/>
<c:url var="basketPage" value="/basket.html"/>
<c:url var="orderPage" value="/order.html"/>
<c:url var="infoPage" value="/info.html"/>
<c:url var="deliveryPage" value="/delivery.html"/>
<c:url var="profilePage" value="/profile.html"/>
<c:url var="logoutPage" value="/logout.html"/>
<c:url var="loginPage" value="/login.html"/>
<c:url var="addToBasket" value="/addToBasket.html"/>

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
                <a class="btn btn-outline-secondary my-2 my-sm-0" href="${basketPage}" style="margin-left: 5px">
                    <i class="fa fa-shopping-cart fa-lg"></i>
                    <text style="color: silver">Корзина</text>
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
    <div style="text-align: center; margin-top: 25px;">Товары</div>
</h2>

<!-- products -->
<div class="container mt-5">
    <div class="row row-cols-1 row-cols-md-3 row-cols-sm-1">
        <jsp:useBean id="products" scope="request" class="java.util.ArrayList"/>
        <c:forEach items="${products}" var="product">
            <c:url var="path" value="${product.imagePath}"/>
            <div class="col mb-4">
                <div class="card border-primary h-100" style="max-width: 400px; min-width: 260px;">
                    <img src="${path}" class="img-fluid" alt="No image"
                         style="max-height: 250px; min-height: 300px">
                    <hr>
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <div class="card-text">
                            <p>${product.price} р</p>
                            <p>${product.description}</p>
                        </div>
                    </div>
                    <div class="card-footer" style="max-height: 60px">
                        <c:choose>
                            <c:when test="${not product.isInBasket}">
                                    <form class="form-inline" action="${addToBasket}" method="post">
                                        <input type="number" step="1" min="1" max="200"
                                               id="productAmount"
                                               name="productAmount"
                                               value="1" required style="padding-top: 5px; max-width: 40px; width: 100%">
                                        <input type="hidden" id="productID" name="productID"
                                               value="${product.id}">
                                        <button type="submit"
                                                class="btn btn-primary ml-auto"
                                                style="">Добавить в корзину
                                        </button>
                                    </form>
                            </c:when>
                            <c:otherwise>
                                <button disabled class="btn btn-secondary float-right"
                                        style="margin-top: auto;">В корзине
                                </button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:forEach>
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