package com.example.web.controller;

import com.example.web.enity.Bill;
import com.example.web.enity.Item;
import com.example.web.enity.Product;
import com.example.web.service.BillService;
import com.example.web.service.IBill;
import com.example.web.service.IProduct;
import com.example.web.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletRemoveFromCart", value = "/ServletRemoveFromCart")
public class ServletRemoveFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        IProduct iProduct = new ProductService();
        try {
        Product product = iProduct.findById(id);
        HttpSession session = request.getSession();
        Bill bill = (Bill) session.getAttribute("bill");
        if(bill!=null){
            List<Item> list= bill.getList();
            boolean check= true;
            int i=0;
            while(check==true){
                while(i<list.size()){
                if(list.get(i).getProduct().getId()== product.getId()){
                    list.remove(i);
                    check= false;
                }
                    else{
                    i++;
                }
                }
                check=false;
            }
            bill.setList(list);
            session.setAttribute("bill",bill);
            request.getRequestDispatcher("ServletCart").forward(request,response);
        }else{
            response.sendRedirect("ServletProduct");
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
