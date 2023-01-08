package com.example.web.controller;


import com.example.web.enity.Bill;
import com.example.web.enity.Item;
import com.example.web.enity.Product;
import com.example.web.service.ClientService;
import com.example.web.service.IClient;
import com.example.web.service.IProduct;
import com.example.web.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletAddtoCart", value = "/ServletAddtoCart")
public class ServletAddtoCart extends HttpServlet {
    IProduct iProduct = new ProductService();
    IClient iClient = new ClientService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String client_name= (String) session.getAttribute("client_name");
        int quantity=1;
        try {
            Product product = iProduct.findById(id);
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            Object obj = session.getAttribute("bill");
            if (obj== null) {
                Item item = new Item();
                item.setProduct(product);
                item.setQuantity(quantity);
                Bill bill = new Bill();
                List<Item> list = new ArrayList<>();
                list.add(item);
                bill.setList(list);
                iClient.findByName(client_name);
                bill.setClient(iClient.findByName(client_name));
                session.setAttribute("bill", bill);
            } else {
                Bill bill = (Bill) session.getAttribute("bill");
                List<Item> list = bill.getList();
                int total =0;
                int shipping=10;
                boolean check= false;
                for (Item item:list){
                    if (item.getProduct().getId() == product.getId()) {
                    item.setQuantity(item.getQuantity()+quantity);
                    check=true;
                    }
                }
                for(int i=0;i<list.size();i++){
                    if(i<list.size()){
                    total+=list.get(i).getQuantity()*list.get(i).getProduct().getPrice();}
                    else{
                        break;
                    }
                }
                if(check==false){
                    Item item= new Item();
                    item.setProduct(product);
                    item.setQuantity(quantity);
                    list.add(item);
                    bill.setClient(iClient.findByName(client_name));
                    bill.setList(list);
                }
                session.setAttribute("ship",shipping);
                session.setAttribute("estimate",total);
                session.setAttribute("bill", bill);
            }
            response.sendRedirect("ServletProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
