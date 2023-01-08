package com.example.web.controller;

import com.example.web.enity.Feedback;
import com.example.web.enity.Service;
import com.example.web.service.FeedbackService;
import com.example.web.service.IFeedback;
import com.example.web.service.IServices;
import com.example.web.service.ServicesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAddNewFeedback", value = "/ServletAddNewFeedback")
@MultipartConfig
public class ServletAddNewFeedback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("addnewFeedback.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String client_name= request.getParameter("client_name");
        String feedback1 = request.getParameter("feedback");
        Part part = request.getPart("image");
        String name_file = part.getSubmittedFileName();
        for (Part part1:request.getParts()
        ) {
            part1.write("E:\\javaproject\\web\\src\\main\\webapp\\image\\"+name_file);
        }
        Feedback feedback = new Feedback();
        feedback.setClient_name(client_name);
        feedback.setFeedback(feedback1);
        feedback.setImage(name_file);
        IFeedback iFeedback = new FeedbackService();
        try {
            iFeedback.insert(feedback);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdminFeedBack");
    }
}
