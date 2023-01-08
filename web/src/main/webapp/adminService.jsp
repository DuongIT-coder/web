<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/22/2022
  Time: 1:48 PM
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
    <button onclick="window.location.href='addnewService.jsp'" type="button" class="btn btn-primary">Add</button>
    <a class="hover-underline-animation" href="ServletAdminMenu">Back</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Hình ảnh</th>
            <th>Mô tả</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service_list" items="${list}">
            <tr>
                <td><c:out value="${service_list.id}"></c:out></td>
                <td><c:out value="${service_list.name}"></c:out></td>
                <td><c:out value="${service_list.price}"></c:out></td>
                <td><img src="./image/${service_list.image}" height="200px" width="200px"></td>
                <td><c:out value="${service_list.description}"></c:out></td>
                <td>
                    <a href="ServletEditService?id=${service_list.id}">Edit</a>
                    <a href="ServletDeleteService?id=${service_list.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
