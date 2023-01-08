<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/23/2022
  Time: 1:07 AM
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
  <form action="ServletEditFeedback" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label >STT</label>
      <input class="form-control" id="id" name="id"  value="${feedback.id}">
    </div>
    <div class="form-group">
      <label >Tên khách hàng</label>
      <input type="text" class="form-control" id="client_name" placeholder="Enter name" name="client_name" value="${feedback.client_name}">
    </div>
    <div class="form-group">
      <label >Phản hồi</label>
      <input type="text" class="form-control" id="feedback" placeholder="Enter feedback" name="feedback" value="${feedback.feedback}">
    </div>
    <div class="form-group">
      <label >Ảnh</label>
      <input type="file" class="form-control" id="file" name="image" >
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>
