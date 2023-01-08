<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/17/2022
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
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
<form id="bill" action="ServletAddNewBill" method="post">
<div class="container">
  <div class="row">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
      <table class="table table-hover">
        <thead>
        <tr>
          <th>Tên sản phẩm</th>
          <th>Số lượng</th>
          <th class="text-center">Giá</th>
          <th class="text-center">Tổng</th>
          <th> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bill" items="${sessionScope.bill.list}">
        <tr>
          <td class="col-sm-8 col-md-6">
            <div class="media">
              <img class="media-object" src="./image/${bill.product.image}" style="width: 200px; height: 200px;"></a>
              <div class="media-body">
                <h4 class="media-heading">${bill.product.name}</h4>
                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
              </div>
            </div>
          </td>
          <td class="col-sm-1 col-md-1" style="text-align: center">
            <button><c:out value="${bill.quantity}"/></button>
          </td>
          <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="${bill.product.price}"/></strong></td>
          <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="${bill.quantity * bill.product.price}"/></strong></td>
          <td class="col-sm-1 col-md-1">
            <button onclick="removeFromCart(${bill.product.id})" type="button" class="btn btn-danger">
              <span class="glyphicon glyphicon-remove"></span> Remove
            </button></td>
        </tr>
        </c:forEach>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Subtotal</h5></td>
          <td class="text-right"><h5><strong>${sessionScope.estimate}</strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Estimated shipping</h5></td>
          <td class="text-right"><h5><strong>${sessionScope.ship}</strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h3>Total</h3></td>
          <td class="text-right"><h3><strong><c:out value="${sessionScope.estimate + sessionScope.ship}"/></strong></h3></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td>
            <button onclick="window.location.href='ServletProduct'" type="button" class="btn btn-default">
              <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
            </button></td>
          <a class="hover-underline-animation" href="ServletProduct">Back</a>
          <td>
            <c:if test="${not empty sessionScope.client_name}">
              <c:if test="${not empty sessionScope.bill.list}">
            <button type="submit" onclick="alert('Đặt hàng thành công')" class="btn btn-success">
              Checkout <span class="glyphicon glyphicon-play"></span>
            </button>
              </c:if>
              <c:if test="${empty sessionScope.bill.list}">
                <button type="submit" onclick="alert('Giỏ hàng trống!!')" class="btn btn-success">
                  Checkout <span class="glyphicon glyphicon-play"></span>
                </button>
              </c:if>
            </c:if>
            <c:if test="${empty sessionScope.client_name}">
            <button onclick="myFunction()" class="btn btn-success">
                Checkout <span class="glyphicon glyphicon-play"></span>
            </button>
            </c:if>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
</form>
<script>
  function removeFromCart(id){
    window.location.href='ServletRemoveFromCart?id='+id
  }
  function myFunction(){
    window.alert('Bạn chưa đăng nhập!!Hãy đăng nhập để mua hàng');
  }
</script>
</body>
</html>
