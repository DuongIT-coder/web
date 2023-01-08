<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/7/2023
  Time: 12:10 AM
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
  <form action="ServletEditAdmin" method="post" >
    <div class="form-group">
      <label >STT</label>
      <input class="form-control" id="id" name="id"  value="${admin.id}">
    </div>
    <div class="form-group">
      <label >Tên</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${admin.name}">
    </div>
    <div class="form-group">
      <label >Địa chỉ</label>
      <input type="text" class="form-control" id="address" placeholder="Enter price" name="address" value="${admin.address}">
    </div>
    <div class="form-group">
      <label>Tên đăng nhập</label>
      <input type="text" class="form-control" id="email" name="email" placeholder="Enter email" value="${admin.email}" >
    </div>
    <div class="form-group">
      <label>Mật khẩu</label>
      <input type="text" class="form-control" id="password" name="password" placeholder="Enter password" value="${admin.password}" >
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>
