package com.example.web.controller;

import com.example.web.enity.Client;
import com.example.web.service.ClientService;
import com.example.web.service.IClient;
import com.example.web.util.ManagerConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletAdminClient", value = "/ServletAdminClient")
public class ServletAdminClient extends HttpServlet {
    IClient iClient= new ClientService();
    ManagerConnect managerConnect= new ManagerConnect();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Client> list = iClient.getAll();
            request.setAttribute("client_list",list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("adminClient.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
