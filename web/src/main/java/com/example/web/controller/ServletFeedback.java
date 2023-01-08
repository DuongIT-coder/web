package com.example.web.controller;

import com.example.web.enity.Feedback;
import com.example.web.enity.Product;
import com.example.web.enity.Service;
import com.example.web.service.*;
import com.example.web.util.ManagerConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletFeedback", value = "/ServletFeedback")
public class ServletFeedback extends HttpServlet {
    ManagerConnect managerConnect = new ManagerConnect();
    IFeedback iFeedback = new FeedbackService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        managerConnect.openConnection();
        try {
            List<Feedback> feedbackList = iFeedback.getAll();
            request.setAttribute("feedback_list",feedbackList);
            request.getRequestDispatcher("feedback.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
