package com.example.web.controller;

import com.example.web.enity.Service;
import com.example.web.service.IServices;
import com.example.web.service.ServicesService;
import com.example.web.util.ManagerConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletService", value = "/ServletService")
public class ServletService extends HttpServlet {
    ManagerConnect managerConnect = new ManagerConnect();
    IServices iServices= new ServicesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Service> serviceList= iServices.getAll();
            request.setAttribute("service_list",serviceList);
            request.getRequestDispatcher("service.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
