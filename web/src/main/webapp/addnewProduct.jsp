<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/22/2022
  Time: 12:33 AM
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
  <form action="ServletAddNewProduct" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label >Tên</label>
      <input type="text" class="form-control" id="name" placeholder="Tên sản phẩm" name="name" >
    </div>
    <div class="form-group">
      <label >Giá</label>
      <input type="text" class="form-control" id="price" placeholder="Giá" name="price" >
    </div>
    <div class="form-group">
      <label >Ảnh</label>
      <input type="file" class="form-control" id="image" name="image">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>
