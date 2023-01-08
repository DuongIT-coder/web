package com.example.web.controller;

import com.example.web.enity.Feedback;
import com.example.web.enity.Product;
import com.example.web.service.FeedbackService;
import com.example.web.service.IFeedback;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletAdminFeedBack", value = "/ServletAdminFeedBack")
public class ServletAdminFeedBack extends HttpServlet {
    IFeedback iFeedback= new FeedbackService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Feedback> feedbackList = iFeedback.getAll();
            request.setAttribute("list", feedbackList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("adminFeedback.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
