package com.example.web.controller;

import com.example.web.enity.Bill;
import com.example.web.enity.Feedback;
import com.example.web.enity.Product;
import com.example.web.enity.Service;
import com.example.web.service.*;
import com.example.web.util.ManagerConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletHome", value = "/ServletHome")
@MultipartConfig
public class ServletHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IServices iServices = new ServicesService();
        IProduct iProduct = new ProductService();
        IFeedback iFeedback = new FeedbackService();
        try {
           List<Service> serviceList = iServices.getAll();
           List<Product> productList= iProduct.getAll();
           List<Feedback>feedbackList=iFeedback.getAll();
           request.setAttribute("service_list",serviceList);
           request.setAttribute("product_list",productList);
           request.setAttribute("feedback_list",feedbackList);
           request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}}
