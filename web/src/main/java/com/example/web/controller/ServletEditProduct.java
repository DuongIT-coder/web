package com.example.web.controller;

import com.example.web.enity.Product;
import com.example.web.service.IProduct;
import com.example.web.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletEditProduct", value = "/ServletEditProduct")
@MultipartConfig
public class ServletEditProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IProduct iProduct = new ProductService();
        try {
            Product product=iProduct.findById(id);
            request.setAttribute("product",product);
            request.getRequestDispatcher("editProduct.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        Part part = request.getPart("image");
        String image = part.getSubmittedFileName();
        IProduct iProduct = new ProductService();
        for (Part part1:request.getParts())
        {
         part1.write("E:\\javaproject\\web\\src\\main\\webapp\\image\\"+image);
        }
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        product.setImage(image);
            try {
                iProduct.edit(product);
                response.sendRedirect("ServletAdminProduct");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
}
}
