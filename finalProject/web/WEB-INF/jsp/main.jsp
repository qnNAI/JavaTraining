<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#" style="color: #1E90FF">WORKSHOP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/error.html">Каталог</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/menu.html">Заказы</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Доставка</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">О нас</a>
            </li>
        </ul>

        <c:set var="authorizedUser" scope="session" value="${sessionScope.authorizedUser}"/>
        <c:if test="${not empty authorizedUser}">
            <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/basket.html"
                  method="post">
                <button class="btn btn-outline-secondary my-2 my-sm-0 form-control" type="submit">
                    <text style="color: silver">Корзина</text>
                </button>
            </form>
        </c:if>
    </div>
</nav>

<h2>
    <div style="text-align: center; margin-top: 25px;">Товары</div>
</h2>


<div class="container mt-5">
    <div class="row row-cols-1 row-cols-md-3">
        <c:forEach items="${products}" var="product">
            <c:url var="path" value="/img/kt_statuette.jpg"/>
            <div class="col mb-4">
                <div class="card border-primary h-100">
                    <img src="${path}" class="img-fluid" alt="Card image cap">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${product.name}</h5>
                        <div class="card-text">
                            <p>Price: ${product.price}</p>
                            <p>Description: ${product.description}</p>
                        </div>
                        <a href="#" class="btn btn-primary float-right align-self-end"
                           style="margin-top: auto">Заказать</a>
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