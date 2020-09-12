<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile edit</title>
    <c:url var="cssFile" value="/css/changeUserInfo.css"/>

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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<c:url var="mainPage" value="/main.html"/>
<c:url var="orderPage" value="/order.html"/>
<c:url var="infoPage" value="/info.html"/>
<c:url var="deliveryPage" value="/delivery.html"/>
<c:url var="logoutPage" value="/logout.html"/>
<c:url var="basketPage" value="/basket.html"/>
<c:url var="loginPage" value="/login.html"/>
<c:url var="changeUserInfo" value="/profile/changeUserInfo.html"/>
<c:url var="changePassword" value="/profile/changePassword.html"/>
<c:url var="profilePage" value="/profile.html"/>
<c:url var="saveProfile" value="/profile/saveUserInfo.html"/>
<c:url var="userManagement" value="/admin/userManagement.html"/>
<c:url var="productMgmt" value="/admin/productMgmt.html"/>
<c:url var="history" value="/history.html"/>
<c:url var="masterOrderMgmt" value="/master/orderMgmt.html"/>

<jsp:useBean id="user" scope="request" type="by.training.finalproject.entity.User"/>

<!-- navbar -->
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
                    <c:when test="${not empty user}">
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
        <a class="btn btn-outline-secondary my-2 my-sm-0" href="${basketPage}">
            <i class="fa fa-shopping-cart fa-lg"></i>
            <text style="color: silver">Корзина</text>
        </a>
        <a class="btn btn-outline-warning my-2 my-sm-0 ml-1" href="${logoutPage}">
            <i class="fa fa-sign-out"></i>
            Выйти
        </a>
    </div>
</nav>
<!-- end navbar -->


<div class="row">
    <div class="col-2">
        <div class="container-fluid mt-3">
            <p class="menu-header">Меню</p>
            <br>
            <p><a class="menu-text" href="${profilePage}">Профиль</a></p>
            <hr>
            <p><a class="menu-text" href="${changePassword}">Изменить пароль</a></p>
            <hr>
            <c:choose>
                <c:when test="${user.role eq 'USER'}">
                    <p><a class="menu-text" href="${history}">История покупок</a></p>
                    <hr>
                </c:when>
                <c:when test="${user.role eq 'ADMINISTRATOR'}">
                    <p><a class="menu-text" href="${userManagement}">Управление пользователями</a></p>
                    <hr>
                    <p><a class="menu-text" href="${productMgmt}">Управление товарами</a></p>
                    <hr>
                </c:when>
                <c:when test="${user.role eq 'MASTER'}">
                    <p><a class="menu-text" href="${masterOrderMgmt}">Управление заказами</a></p>
                    <hr>
                </c:when>
            </c:choose>
        </div>
    </div>
    <div class="col-10">
        <div class="header-text">
            <h2>Изменение личных данных</h2>
        </div>

        <div class="container mt-5">
            <h5>Личные данные: </h5><br>
            <form method="post" action="${saveProfile}" class="form">
                <table>
                    <tr>
                        <td>
                            <div class="row-text">
                                Имя пользователя:
                            </div>
                        </td>
                        <td>
                            <div class="row-value">
                                <input type="text" name="login" placeholder="${user.login}" class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row-text">
                                Имя:
                            </div>
                        </td>
                        <td>
                            <div class="row-value">
                                <input type="text" name="name" placeholder="${user.name}" class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row-text">
                                Фамилия:
                            </div>
                        </td>
                        <td>
                            <div class="row-value">
                                <input type="text" name="surname" placeholder="${user.surname}" class="form-control">
                            </div>
                        </td>
                    </tr>
                    <c:choose>
                        <c:when test="${not empty user.patronymic}">
                            <tr>
                                <td>
                                    <div class="row-text">
                                        Отчество:
                                    </div>
                                </td>
                                <td>
                                    <div class="row-value">
                                        <input type="text" name="patronymic" placeholder="${user.patronymic}" class="form-control">
                                    </div>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>
                                    <div class="row-text">
                                        Отчество:
                                    </div>
                                </td>
                                <td>
                                    <div class="row-value">
                                        <input type="text" name="patronymic" placeholder="-" class="form-control">
                                    </div>
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </table>
                <br><br><h5>Контактные данные: </h5><br>
                <table>
                    <tr>
                        <td>
                            <div class="row-text">
                                Почта:
                            </div>
                        </td>
                        <td>
                            <div class="row-value">
                                <input type="text" name="email" placeholder="${user.email}" class="form-control">
                            </div>
                        </td>
                    </tr>
                    <c:choose>
                        <c:when test="${not empty user.phone}">
                            <tr>
                                <td>
                                    <div class="row-text">
                                        Телефон:
                                    </div>
                                </td>
                                <td>
                                    <div class="row-value">
                                        <input type="text" name="phone" placeholder="${user.phone}" class="form-control">
                                    </div>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>
                                    <div class="row-text">
                                        Телефон:
                                    </div>
                                </td>
                                <td>
                                    <div class="row-value">
                                        <input type="text" name="phone" placeholder="-" class="form-control">
                                    </div>
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </table>
                <div class="row mt-2">
                    <button type="submit" class="btn btn-success">Изменить</button>
                    <a class="btn btn-danger ml-2" href="${profilePage}">Отмена</a>
                </div>

            </form>
        </div>
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