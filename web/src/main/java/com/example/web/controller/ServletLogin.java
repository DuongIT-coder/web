package com.example.web.controller;

import com.example.web.enity.Admin;
import com.example.web.enity.Client;
import com.example.web.service.AdminService;
import com.example.web.service.ClientService;
import com.example.web.service.IAdmin;
import com.example.web.service.IClient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    IClient iClient = new ClientService();
    IAdmin iAdmin= new AdminService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email= request.getParameter("email");
        String password = request.getParameter("password");
        try {
            Client client = iClient.login(email,password);
            Admin admin= iAdmin.login(email,password);
            if(admin.getEmail()!=null){
                HttpSession session = request.getSession();
                session.setAttribute("admin_name",admin.getName());
                response.sendRedirect("ServletAdminMenu");
            }else if(client.getName() != null ){
                HttpSession session = request.getSession();
                session.setAttribute("client_name",client.getName());
                response.sendRedirect("ServletHome");
            }
            else if(client.getName() == null){
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
