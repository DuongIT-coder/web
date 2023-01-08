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

@WebServlet(name = "ServletEditFeedback", value = "/ServletEditFeedback")
@MultipartConfig
public class ServletEditFeedback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IFeedback iFeedback = new FeedbackService();
        try {
            Feedback feedback = iFeedback.findById(id);
            request.setAttribute("feedback",feedback);
            request.getRequestDispatcher("editFeedback.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String client_name = request.getParameter("client_name");
        String feedback = request.getParameter("feedback");
        Part part = request.getPart("image");
        String image = part.getSubmittedFileName();
        for (Part part1:request.getParts()
        ) {
                part1.write("E:\\javaproject\\web\\src\\main\\webapp\\image\\" + image);
        }
        Feedback feedback1= new Feedback();
        feedback1.setId(id);
        feedback1.setClient_name(client_name);
        feedback1.setFeedback(feedback);
        feedback1.setImage(image);
        IFeedback iFeedback = new FeedbackService();
        try {
            iFeedback.edit(feedback1);
            response.sendRedirect("ServletAdminFeedBack");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
