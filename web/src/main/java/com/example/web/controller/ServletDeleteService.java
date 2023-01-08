package com.example.web.controller;

import com.example.web.service.IProduct;
import com.example.web.service.IServices;
import com.example.web.service.ProductService;
import com.example.web.service.ServicesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteService", value = "/ServletDeleteService")
public class ServletDeleteService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        IServices iServices= new ServicesService();
        try {
            iServices.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdminService");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
