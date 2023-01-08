package com.example.web.controller;

import com.example.web.service.AdminService;
import com.example.web.service.IAdmin;
import com.example.web.service.IProduct;
import com.example.web.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteAdmin", value = "/ServletDeleteAdmin")
public class ServletDeleteAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        IAdmin iAdmin = new AdminService();
        try {
            iAdmin.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdmin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
