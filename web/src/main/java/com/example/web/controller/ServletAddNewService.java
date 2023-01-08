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

@WebServlet(name = "ServletAddNewService", value = "/ServletAddNewService")
@MultipartConfig
public class ServletAddNewService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("addnewService.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String price = request.getParameter("price");
        Part part = request.getPart("image");
        String description = request.getParameter("description");
        String name_file = part.getSubmittedFileName();
        for (Part part1:request.getParts()
        ) {
            part1.write("E:\\javaproject\\web\\src\\main\\webapp\\image\\"+name_file);
        }
        Service service = new Service();
        service.setName(name);
        service.setPrice(Integer.parseInt(price));
        service.setImage(name_file);
        service.setDescription(description);
        IServices iServices = new ServicesService();
        try {
            iServices.insert(service);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdminService");
    }
    }
