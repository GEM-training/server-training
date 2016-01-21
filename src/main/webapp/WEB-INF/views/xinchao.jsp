<%--
  Created by IntelliJ IDEA.
  User: phuong
  Date: 1/19/2016
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello</h1>
    <c:forEach var="u" items="${dealers}">
        Username: ${u.name}  <br>
    </c:forEach>
<hr>
    <h3>Danh sach kho hang cua dealer 1</h3>
    <c:forEach var="in" items="${ins}">
        Username: ${in.name}  <br>
    </c:forEach>
    <hr/>
    <h3>Danh sach bill dealer 1</h3>
    <c:forEach var="b" items="${bills}">
        Username: ${b.state}  <br>
    </c:forEach>

    <hr/>
    <h3>Danh sach UnitDealer cua dealer 1</h3>
    <c:forEach var="ud" items="${uds}">
        Username: ${ud.price}  <br>
    </c:forEach>


</body>
</html>
