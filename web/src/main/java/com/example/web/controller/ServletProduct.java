package com.example.web.controller;

import com.example.web.enity.Bill;
import com.example.web.enity.Item;
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

@WebServlet(name = "ServletProduct", value = "/ServletProduct")
public class ServletProduct extends HttpServlet {
    ManagerConnect managerConnect = new ManagerConnect();
    IProduct iProduct = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> productList = iProduct.getAll();
            request.setAttribute("product_list", productList);
            request.getRequestDispatcher("product.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
