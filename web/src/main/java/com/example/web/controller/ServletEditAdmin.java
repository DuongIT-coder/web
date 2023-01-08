package com.example.web.controller;

import com.example.web.enity.Admin;
import com.example.web.enity.Feedback;
import com.example.web.service.AdminService;
import com.example.web.service.FeedbackService;
import com.example.web.service.IAdmin;
import com.example.web.service.IFeedback;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletEditAdmin", value = "/ServletEditAdmin")
public class ServletEditAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IAdmin iAdmin = new AdminService();
        try {
            Admin admin =iAdmin.findById(id);
            request.setAttribute("admin",admin);
            request.getRequestDispatcher("editAdmin.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("admin_name");
        String address = request.getParameter("address");
        String email= request.getParameter("email");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setAddress(address);
        admin.setEmail(email);
        admin.setPassword(password);
        IAdmin iAdmin = new AdminService();
        try {
            iAdmin.edit(admin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdmin");
    }
}
