<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/22/2022
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form action="ServletEditService" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label >STT</label>
        <input class="form-control" id="id" name="id"  value="${service.id}">
    </div>
    <div class="form-group">
        <label >Tên dịch vụ</label>
        <input type="text" class="form-control" id="name"  name="name" placeholder="Nhập tên dịch vụ" value="${service.name}">
    </div>
    <div class="form-group">
        <label >Giá</label>
        <input type="text" class="form-control" id="price" placeholder="Nhập giá" name="price" value="${service.price}">
    </div>
    <div class="form-group">
        <label >Ảnh</label>
        <input type="file" class="form-control" id="file" name="image" >
    </div>
    <div class="form-group">
        <label >Mô tả</label>
        <input type="text" class="form-control" id="description" placeholder="Nhập mô tả" name="description" value="${service.description}">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>
