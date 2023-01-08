package com.example.web.controller;

import com.example.web.enity.Product;
import com.example.web.enity.Service;
import com.example.web.service.IServices;
import com.example.web.service.ServicesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletAdminService", value = "/ServletAdminService")
public class ServletAdminService extends HttpServlet {
    IServices iServices = new ServicesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Service> serviceList = iServices.getAll();
            request.setAttribute("list", serviceList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("adminService.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
