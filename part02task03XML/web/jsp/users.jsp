<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Info</title>
</head>
    <body>
        <h1>Users Info</h1>

        <p>Parser: <%= request.getParameter("parser") %> </p>

        <form action="/xmlparse">
            Users: <br>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>username</th>
                    <th>password</th>
                    <th>role</th>
                    <th>state</th>
                    <th>name</th>
                    <th>surname</th>
                    <th>patronymic</th>
                    <th>email</th>
                    <th>phone</th>
                </tr>

                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.role}</td>
                        <td>${user.state}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.patronymic}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                    </tr>
                </c:forEach>
            </table> <br>

            Purchases: <br>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>username</th>
                    <th>state</th>
                    <th>obtainingMethod</th>
                    <th>address</th>
                    <th>final price</th>
                    <th>date</th>
                    <th>amount</th>
                </tr>

                <c:forEach items="${users}" var="user">
                    <c:forEach items="${user.purchases}" var="purchase">
                        <tr>
                            <td>${purchase.id}</td>
                            <td>${user.username}</td>
                            <td>${purchase.state}</td>
                            <td>${purchase.obtaining_method}</td>
                            <td>${purchase.address}</td>
                            <td>${purchase.finalPrice}</td>
                            <td>${purchase.date}</td>
                            <td>${purchase.amount}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </table> <br>

            Products: <br>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>username</th>
                    <th>purchase ID</th>
                    <th>name</th>
                    <th>price</th>
                    <th>description</th>
                    <th>image path</th>
                </tr>

                <c:forEach items="${users}" var="user">
                    <c:forEach items="${user.purchases}" var="purchase">
                        <c:forEach items="${purchase.products}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${user.username}</td>
                                <td>${purchase.id}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.description}</td>
                                <td>${product.image_path}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>
            </table> <br>

            <input type="submit" name="submit" value="Back"/>

        </form>
    </body>
</html>