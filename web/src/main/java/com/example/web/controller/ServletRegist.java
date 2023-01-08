package com.example.web.controller;

import com.example.web.enity.Client;
import com.example.web.service.ClientService;
import com.example.web.service.IClient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletRegist", value = "/ServletRegist")
public class ServletRegist extends HttpServlet {
    IClient iClient = new ClientService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email= request.getParameter("email");
        String password= request.getParameter("password");
        String address=request.getParameter("address");
        String phonenumber=request.getParameter("phonenumber");
        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setAddress(address);
        client.setPhonenumber(phonenumber);
        try {
            if(iClient.findByEmail(email)!=client){
            iClient.regist(client);
            HttpSession session = request.getSession();
            session.setAttribute("client_name",client.getName());
            response.sendRedirect("ServletHome");
            }else{
                response.sendRedirect("login.jsp");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
