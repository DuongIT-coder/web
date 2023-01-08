package com.example.web.controller;

import com.example.web.service.FeedbackService;
import com.example.web.service.IFeedback;
import com.example.web.service.IServices;
import com.example.web.service.ServicesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteFeedback", value = "/ServletDeleteFeedback")
public class ServletDeleteFeedback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        IFeedback  iFeedback = new FeedbackService();
        try {
            iFeedback.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdminFeedBack");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
