package com.example.web.controller;

import com.example.web.enity.Product;
import com.example.web.service.IProduct;
import com.example.web.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAddNewProduct", value = "/ServletAddNewProduct")
@MultipartConfig
public class ServletAddNewProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("addnewProduct.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String price = request.getParameter("price");
        Part part = request.getPart("image");
        String name_file = part.getSubmittedFileName();
        for (Part part1:request.getParts()
        ) {
            part1.write("E:\\javaproject\\web\\src\\main\\webapp\\image\\"+name_file);
        }
        Product product= new Product();
        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        product.setImage(name_file);
        IProduct iProduct = new ProductService();
        try {
            iProduct.insert(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ServletAdminProduct");
    }
}
