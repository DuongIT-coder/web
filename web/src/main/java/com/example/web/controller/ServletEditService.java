package com.example.web.controller;

import com.example.web.enity.Product;
import com.example.web.enity.Service;
import com.example.web.service.IProduct;
import com.example.web.service.IServices;
import com.example.web.service.ProductService;
import com.example.web.service.ServicesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletEditService", value = "/ServletEditService")
@MultipartConfig
public class ServletEditService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IServices iServices= new ServicesService();
        try {
            Service service =iServices.findById(id);
            request.setAttribute("service",service);
            request.getRequestDispatcher("editService.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description =request.getParameter("description");
        Part part = request.getPart("image");
        String image = part.getSubmittedFileName();
        for (Part part1:request.getParts()
        ) {
            part1.write("E:\\javaproject\\web\\src\\main\\webapp\\image\\"+image);
        }
        Service service= new Service();
        service.setId(id);
        service.setName(name);
        service.setPrice(Integer.parseInt(price));
        service.setImage(image);
        service.setDescription(description);
        IServices iServices= new ServicesService();
        try {
            iServices.edit(service);
            response.sendRedirect("ServletAdminService");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
