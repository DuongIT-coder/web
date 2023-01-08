package com.example.web.controller;

import com.example.web.service.BillService;
import com.example.web.service.IBill;
import com.example.web.service.IProduct;
import com.example.web.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteBill", value = "/ServletDeleteBill")
public class ServletDeleteBill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        IBill iBill = new BillService();
        try {
            iBill.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdminBill");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
