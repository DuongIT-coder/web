package com.example.web.controller;

import com.example.web.enity.Bill;
import com.example.web.enity.Client;
import com.example.web.service.BillService;
import com.example.web.service.ClientService;
import com.example.web.service.IBill;
import com.example.web.service.IClient;
import com.example.web.util.ManagerConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletAdminBill", value = "/ServletAdminBill")
public class ServletAdminBill extends HttpServlet {
    IBill iBill= new BillService();
    ManagerConnect managerConnect= new ManagerConnect();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Bill> list = iBill.getAll();
            request.setAttribute("bill_list",list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("adminBill.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
