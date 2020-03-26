<%--
  Created by IntelliJ IDEA.
  User: Triss
  Date: 19.03.2020
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>XmlParse</title>
  </head>
  <body>
  <h1>XML SERVLET</h1>

  <form action="${pageContext.request.contextPath}/chooseparser">

    <p>Choose parser: </p>

    <p><input type="radio" name="parser" value="SAX" checked/>SAX parser</p>
    <p><input type="radio" name="parser" value="DOM"/>DOM parser</p>
    <p><input type="radio" name="parser" value="StAX"/>StAX parser</p>
    <br>

    XML file path: <br>
    <input type="text" name="pathXML" size="40"> <br><br>

    XSD schema path: <br>
    <input type="text" name="pathXSD" size="40"> <br><br>

    <input type="submit" name="submit" value="Submit"/>

  </form>

  </body>
</html>
