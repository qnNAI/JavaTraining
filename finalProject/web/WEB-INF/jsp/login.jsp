<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

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

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="nav navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Каталог</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Заказы</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Доставка</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">О нас</a>
            </li>
        </ul>
    </div>

    <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/basket.jsp">
        <button class="btn btn-outline-primary my-2 my-sm-0" type="button">Корзина</button>
    </form>
</nav>

<h2>
    <div style="text-align: center; margin-top: 25px;">Вход</div>
</h2>

    <form action="${pageContext.request.contextPath}/login.html" method="post" role="form" style="width: 500px; margin: 75px auto auto;">
        <div class="form-group">
            <LABEL for="login">Имя пользователя</LABEL>
            <INPUT type="text" class="form-control" id="login" name="login" placeholder="Имя пользователя" required>
        </div>
        <div class="form-group">
            <LABEL for="password">Пароль</LABEL>
            <INPUT type="password" class="form-control" id="password" name="password" placeholder="Пароль" required>
        </div>
        <BUTTON class="btn btn-outline-success my-2 my-sm-0" type="submit">Войти</BUTTON>
    </form>


</body>
</html>