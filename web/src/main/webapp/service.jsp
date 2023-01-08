<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/14/2022
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Barber X - Barber Shop Template</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="Free Website Template" name="keywords">
  <meta content="Free Website Template" name="description">

  <!-- Favicon -->
  <link href="img/favicon.ico" rel="icon">

  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700;800&display=swap" rel="stylesheet">

  <!-- CSS Libraries -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <!-- Template Stylesheet -->
  <link href="css/style.css" rel="stylesheet">
</head>
<style>
  .snip1582 {
    background-color: #c47135;
    border: none;
    color: #ffffff;
    cursor: pointer;
    display: inline-block;
    font-family: 'BenchNine', Arial, sans-serif;
    font-size: 1em;
    font-size: 7px;
    line-height: 1em;
    margin: 19px 2px;
    outline: none;
    padding: 12px 20px 17px;
    position: relative;
    text-transform: uppercase;
    font-weight: 500;
  }

  .snip1582:before,
  .snip1582:after {
    border-color: transparent;
    -webkit-transition: all 0.25s;
    transition: all 0.25s;
    border-style: solid;
    border-width: 0;
    content: "";
    height: 24px;
    position: absolute;
    width: 24px;
  }

  .snip1582:before {
    border-color: #c47135;
    border-top-width: 2px;
    left: 0px;
    top: -5px;
  }

  .snip1582:after {
    border-bottom-width: 2px;
    border-color: #c47135;
    bottom: -5px;
    right: 0px;
  }

  .snip1582:hover,
  .snip1582.hover {
    background-color: #c47135;
  }

  .snip1582:hover:before,
  .snip1582.hover:before,
  .snip1582:hover:after,
  .snip1582.hover:after {
    height: 100%;
    width: 100%;
  }
  .user{
    text-decoration-color: #f8f9fa;
  }
</style>

<body>
<!-- Top Bar Start -->
<div class="top-bar d-none d-md-block">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-6">
        <div class="top-bar-left">
          <div class="text">
            <h2>8:00 - 9:00</h2>
            <p>Opening Hour Mon - Fri</p>
          </div>
          <div class="text">
            <h2>+123 456 7890</h2>
            <p>Call Us For Appointment</p>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="top-bar-right">
          <div class="social">
            <a href=""><i class="fab fa-twitter"></i></a>
            <a href=""><i class="fab fa-facebook-f"></i></a>
            <a href=""><i class="fab fa-linkedin-in"></i></a>
            <a href=""><i class="fab fa-instagram"></i></a>
            <div class="btn-group" style="background-color:#1D2434 ">
              <c:if test="${sessionScope.client_name ==null}">
                <button  onclick="window.location.href='login.jsp'" type="button" class="snip1582" >Log_in</button>
                <button onclick="window.location.href='regist.jsp'" type="button" class="snip1582" >Regist</button>
              </c:if>
              <c:if test="${sessionScope.client_name != null}">
                <button onclick="window.location.href='ServletLogOut'" type="button" class="snip1582" >Logout</button>
              </c:if>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Top Bar End -->

<!-- Nav Bar Start -->
<div class="navbar navbar-expand-lg bg-dark navbar-dark" >
  <div class="container-fluid" style="background-image: url('./image/tải xuống.jfif')">
    <a href="ServletHome" class="navbar-brand">Barber <span>X</span></a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
      <div class="navbar-nav ml-auto">
        <a href="ServletHome" class="nav-item nav-link">Home</a>
        <a href="ServletService" class="nav-item nav-link">Service</a>
        <a href="ServletProduct" class="nav-item nav-link">Product</a>
        <a href="ServletFeedback" class="nav-item nav-link">Feedback</a>
        <a href="ServletCart" class="nav-item nav-link"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a>
        <a class="nav-item nav-link">
          <span class="glyphicon glyphicon-user"></span>
          <c:out value="${sessionScope.client_name}"></c:out>
        </a>
      </div>
    </div>
  </div>
</div>
<!-- Nav Bar End -->

<!-- Page Header Start -->
<div class="page-header">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <h2>Service</h2>
      </div>
      <div class="col-12">
        <a href="ServletHome">Home</a>
        <a href="ServletService">Service</a>
      </div>
    </div>
  </div>
</div>
<!-- Page Header End -->


<!-- Service Start -->
<!-- Service Start -->
<div class="service">
  <div class="container">
    <div class="section-header text-center">
      <p>Our Salon Services</p>
      <h2>Best Salon and Barber Services for You</h2>
    </div>
    <div class="row">
      <c:forEach var="service" items="${service_list}">
        <div class="col-lg-4 col-md-6">
          <div class="service-item">
            <div class="service-img">
              <img src="./image/${service.image}" alt="Image">
            </div>
            <h3>${service.name}</h3>
            <p>${service.price}</p>
            <p>
                ${service.description}
            </p>
            <a class="btn" href="">Learn More</a>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</div>


<!-- Footer Start -->
<div class="footer">
  <div class="container">
    <div class="row">
      <div class="col-lg-7">
        <div class="row">
          <div class="col-md-6">
            <div class="footer-contact">
              <h2>Salon Address</h2>
              <p><i class="fa fa-map-marker-alt"></i>123 Street, New York, USA</p>
              <p><i class="fa fa-phone-alt"></i>+012 345 67890</p>
              <p><i class="fa fa-envelope"></i>info@example.com</p>
              <div class="footer-social">
                <a href=""><i class="fab fa-twitter"></i></a>
                <a href=""><i class="fab fa-facebook-f"></i></a>
                <a href=""><i class="fab fa-youtube"></i></a>
                <a href=""><i class="fab fa-instagram"></i></a>
                <a href=""><i class="fab fa-linkedin-in"></i></a>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="footer-link">
              <h2>Quick Links</h2>
              <a href="">Terms of use</a>
              <a href="">Privacy policy</a>
              <a href="">Cookies</a>
              <a href="">Help</a>
              <a href="">FQAs</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-5">
        <div class="footer-newsletter">
          <h2>Newsletter</h2>
          <p>
            Lorem ipsum dolor sit amet elit. Quisque eu lectus a leo dictum nec non quam. Tortor eu placerat rhoncus, lorem quam iaculis felis, sed lacus neque id eros.
          </p>
          <div class="form">
            <input class="form-control" placeholder="Email goes here">
            <button class="btn">Submit</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container copyright">
    <div class="row">
      <div class="col-md-6">
        <p>&copy; <a href="#">Your Site Name</a>, All Right Reserved.</p>
      </div>
    </div>
  </div>
</div>
<!-- Footer End -->

<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/isotope/isotope.pkgd.min.js"></script>
<script src="lib/lightbox/js/lightbox.min.js"></script>

<!-- Contact Javascript File -->
<script src="mail/jqBootstrapValidation.min.js"></script>
<script src="mail/contact.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>
</html>
