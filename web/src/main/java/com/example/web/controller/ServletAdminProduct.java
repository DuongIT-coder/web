package com.example.web.controller;

import com.example.web.enity.Product;
import com.example.web.service.IProduct;
import com.example.web.service.ProductService;
import com.example.web.util.ManagerConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletAdminProduct", value = "/ServletAdminProduct")
public class ServletAdminProduct extends HttpServlet {
    IProduct iProduct = new ProductService();
    ManagerConnect managerConnect = new ManagerConnect();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> productList = iProduct.getAll();
            request.setAttribute("list", productList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("adminProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
