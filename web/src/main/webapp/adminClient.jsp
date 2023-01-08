<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/22/2022
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
    .hover-underline-animation {
        display: inline-block;
        position: relative;
        color: #0087ca;
    }

    .hover-underline-animation::after {
        content: '';
        position: absolute;
        width: 100%;
        transform: scaleX(0);
        height: 2px;
        bottom: 0;
        left: 0;
        background-color: #0087ca;
        transform-origin: bottom right;
        transition: transform 0.25s ease-out;
    }

    .hover-underline-animation:hover::after {
        transform: scaleX(1);
        transform-origin: bottom left;
    }
</style>
<body>
<div class="container">
<a class="hover-underline-animation" href="ServletAdminMenu">Back</a>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Password</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client_list" items="${client_list}">
        <tr>
            <td><c:out value="${client_list.id}"></c:out></td>
            <td><c:out value="${client_list.name}"></c:out></td>
            <td><c:out value="${client_list.email}"></c:out></td>
            <td><c:out value="${client_list.password}"></c:out></td>
            <td>
                <a href="ServletDeleteClient?id=${client_list.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
