<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

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
<nav class="navbar navbar-expand-lg navbar-fixed-top navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/main.html" style="color: #1E90FF">WORKSHOP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="nav navbar-nav">
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
    </div>
</nav>

<h2>
    <div style="text-align: center; margin-top: 25px;">Регистрация</div>
</h2>

<div class="container-fluid mb-5 mt-5">
    <div class="row justify-content-center">
        <form class="form" action="${pageContext.request.contextPath}/registration.html" method="post"
              style="max-width: 800px; width: 100%; padding-left: 15px; padding-right: 15px;">
            <div class="row">
                <div class="col form-group">
                    <LABEL for="login">Имя пользователя</LABEL>
                    <INPUT type="text" class="form-control" id="login" name="login" placeholder="Имя пользователя"
                           required>
                </div>
                <div class="col form-group">
                    <LABEL for="email">Почта</LABEL>
                    <INPUT type="email" class="form-control" id="email" name="email" placeholder="Почта" required>
                </div>
            </div>
            <div class="row">
                <div class="col form-group">
                    <LABEL for="password">Пароль</LABEL>
                    <INPUT type="password" class="form-control" id="password" name="password" placeholder="Пароль"
                           required>
                </div>
                <div class="col form-group">
                    <LABEL for="password">Подтвердите пароль</LABEL>
                    <INPUT type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                           placeholder="Пароль"
                           required>
                </div>
            </div>
            <div class="row">
                <div class="col form-group">
                    <LABEL for="name">Имя</LABEL>
                    <INPUT type="text" class="form-control" id="name" name="name" placeholder="Имя" required>
                </div>
                <div class="col form-group">
                    <LABEL for="surname">Фамилия</LABEL>
                    <INPUT type="text" class="form-control" id="surname" name="surname" placeholder="Фамилия" required>
                </div>
            </div>
            <div class="row">
                <div class="col form-group">
                    <LABEL for="patronymic">Отчество</LABEL>
                    <INPUT type="text" class="form-control" id="patronymic" name="patronymic" placeholder="Отчество">
                </div>
                <div class="col form-group">
                    <LABEL for="phone">Телефон</LABEL>
                    <INPUT type="text" class="form-control" id="phone" name="phone" placeholder="Телефон">
                </div>
            </div>

            <div class="form-group">
                <BUTTON class="btn btn-outline-primary my-2 my-sm-0" type="submit">Зарегистрироваться</BUTTON>
                <a class="btn btn-outline-success"
                   href="${pageContext.request.contextPath}/login.html">Вход</a>
            </div>
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