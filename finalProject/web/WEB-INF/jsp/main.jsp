<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <c:url var="cssFile" value="/css/main.css"/>

    <script src="https://use.fontawesome.com/0227303a93.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="${cssFile}"/>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
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
<c:set var="page" scope="request" value="${requestScope.page}"/>
<c:set var="pageAmount" scope="session" value="${sessionScope.pageAmount}"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${mainPage}">WORKSHOP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link nav-item" href="${infoPage}">О нас</a>
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
                <a class="btn btn-outline-secondary my-2 my-sm-0" href="${basketPage}">
                    <i class="fa fa-shopping-cart fa-lg"></i>
                    <text style="color: silver">Корзина</text>
                </a>
                <a class="btn btn-outline-primary my-2 my-sm-0 ml-1" href="${profilePage}">
                    <i class="fa fa-user-circle"></i>
                    Личный кабинет
                </a>
                <a class="btn btn-outline-warning my-2 my-sm-0 ml-1" href="${logoutPage}">
                    <i class="fa fa-sign-out"></i>
                    Выйти
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
<!-- end nav -->

<h2>
    <div style="text-align: center; margin-top: 25px;">Товары</div>
</h2>

<!-- products -->
<div class="container mt-5">
    <div class="row row-cols-lg-3 row-cols-md-2 row-cols-auto">
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
                            <p>${product.id}</p>
                        </div>
                    </div>
                    <div class="card-footer" style="max-height: 60px">
                        <c:choose>
                            <c:when test="${not product.isInBasket}">
                                <form class="form-inline" action="${addToBasket}" method="post">
                                    <input class="input-amount" type="number" step="1" min="1" max="200"
                                           id="productAmount"
                                           name="productAmount"
                                           value="1" required>
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

<div class="row justify-content-center mb-5">
    <nav aria-label="Page navigation">
        <ul class="pagination pagination-lg">
            <li class="page-item">
                <form action="${mainPage}" method="post">
                    <input type="hidden" value="${page - 1}" name="page">
                    <input type="hidden" value="${pageAmount}" name="pageAmount">
                    <button class="page-link" type="submit">&laquo;</button>
                </form>
            </li>
            <c:choose>
                <c:when test="${pageAmount > 2}">
                    <c:choose>
                        <c:when test="${page > 1 && page < pageAmount}">
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="1" name="page">
                                    <button class="page-link" type="submit">1</button>
                                </form>
                            </li>
                            <li class="page-item"><a class="page-link current" href="#">${page}</a></li>
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="${pageAmount}" name="page">
                                    <button class="page-link" type="submit">${pageAmount}</button>
                                </form>
                            </li>
                        </c:when>
                        <c:when test="${page eq 1}">
                            <li class="page-item"><a class="page-link current" href="#">1</a></li>
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="2" name="page">
                                    <button class="page-link" type="submit">2</button>
                                </form>
                            </li>
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="${pageAmount}" name="page">
                                    <button class="page-link" type="submit">${pageAmount}</button>
                                </form>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="1" name="page">
                                    <button class="page-link" type="submit">1</button>
                                </form>
                            </li>
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="${pageAmount - 1}" name="page">
                                    <button class="page-link" type="submit">${pageAmount - 1}</button>
                                </form>
                            </li>
                            <li class="page-item"><a class="page-link current" href="#">${pageAmount}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${pageAmount eq 2}">
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="1" name="page">
                                    <button class="page-link" type="submit">1</button>
                                </form>
                            </li>
                            <li class="page-item">
                                <form action="${mainPage}" method="post">
                                    <input type="hidden" value="2" name="page">
                                    <button class="page-link" type="submit">2</button>
                                </form>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link current" href="#">1</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
            <li class="page-item">
                <form action="${mainPage}" method="post">
                    <input type="hidden" value="${page + 1}" name="page">
                    <button class="page-link" type="submit">&raquo;</button>
                </form>
            </li>
        </ul>
    </nav>
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