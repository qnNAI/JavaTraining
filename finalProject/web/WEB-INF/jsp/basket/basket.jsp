<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="customTag" prefix="ctg" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basket</title>

    <script src="https://use.fontawesome.com/0227303a93.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="css/basket.css"/>

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

    <script src="js/ChangeProductBasketButton.js" type="text/javascript"></script>

</head>
<body>
<c:url var="mainPage" value="/main.html"/>
<c:url var="orderPage" value="/order.html"/>
<c:url var="infoPage" value="/info.html"/>
<c:url var="deliveryPage" value="/delivery.html"/>
<c:url var="loginPage" value="/login.html"/>
<c:url var="logoutPage" value="/logout.html"/>
<c:url var="basketPage" value="/basket.html"/>
<c:url var="profilePage" value="/profile.html"/>
<c:url var="removeFromBasket" value="/removeFromBasket.html"/>
<c:url var="changeProductInBasket" value="/changeProductInBasket.html"/>
<c:url var="purchaseConfirmation" value="/purchaseConfirmation.html"/>

<c:set var="authorizedUser" scope="page" value="${sessionScope.authorizedUser}"/>

<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${mainPage}">WORKSHOP</a>
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
                    <i class="fa fa-sign-in"></i>
                    Войти
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
<!-- end navbar -->


<jsp:useBean id="listOfProductList" scope="request" class="java.util.ArrayList"/>
<c:choose>
    <c:when test="${not empty listOfProductList}">
        <c:set var="sum" value="0"/>
        <h2>
            <div style="text-align: center; margin-top: 25px;">Корзина</div>
        </h2>
        <div class="row">
            <div class="col-9">
                <table>
                    <c:forEach items="${listOfProductList}" var="productList">
                        <tr>
                            <td><img src="${productList.product.imagePath}" alt="No image"></td>
                            <td>
                                <h3>${productList.product.name}</h3>
                                <h6>${productList.product.description}</h6>
                            </td>

                            <form class="form" method="post" action="${changeProductInBasket}">
                                <input type="hidden" id="productIDChange" name="productIDchange"
                                       value="${productList.product.id}">
                                <input type="hidden" id="productFinalPrice" name="productFinalPrice"
                                       value="${productList.finalPrice}">
                                <td>
                                    <h5>${productList.finalPrice} р</h5>
                                    <input type="number" step="1" min="1" max="200" id="productAmount"
                                           name="productAmount"
                                           value="${productList.amount}" required style="margin-top: auto">
                                </td>
                                <td>
                                    <button type="submit" id="changeBtn" name="changeBtn"
                                            class="btn btn-primary hidden-element"
                                            style="margin-top: auto;">Изменить
                                    </button>
                                </td>
                            </form>

                            <form class="form" method="post" action="${removeFromBasket}">
                                <td>
                                    <input type="hidden" id="productID" name="productID"
                                           value="${productList.product.id}">
                                    <button type="submit" class="btn btn-warning" style="margin-top: auto;">Удалить
                                    </button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-3">
                <div class="container">
                    <c:set var="sum" value="${ctg:sum(listOfProductList)}"/>
                    <h4>Товаров: ${listOfProductList.size()}</h4>
                    <h4>Итого: ${sum} р</h4>
                    <form method="post" action="${purchaseConfirmation}">
                        <input type="hidden" name="amount" value="${listOfProductList.size()}">
                        <input type="hidden" name="sum" value="${sum}">
                        <button class="btn btn-danger btn-block" type="submit">Оформить покупку <i
                                class="fa fa-chevron-right"></i></button>
                    </form>

                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <h3>
            <div style="text-align: center; margin-top: 25px;">Корзина пуста</div>
        </h3>
    </c:otherwise>
</c:choose>


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