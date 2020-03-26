<%@ page import="by.training.customTag.view.VendorMap" %><%--
  Created by IntelliJ IDEA.
  User: Triss
  Date: 23.03.2020
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <ctg:info-time/>

  <% request.setAttribute("user", "Administrator"); %>

  <ctg:hello role="${ user }"/>

  <% VendorMap map = new VendorMap();
    request.setAttribute("rw", map); %>

  <ctg:table-revenue rows="${ rw.size }" head="Revenue">
    ${ rw.revenue }
  </ctg:table-revenue >
  <br/>
  <ctg:table-revenue>5 rub BulbaComp</ctg:table-revenue >

  </body>
</html>
