package com.example.web.controller;

import com.example.web.enity.Bill;
import com.example.web.enity.Client;
import com.example.web.enity.Item;
import com.example.web.service.BillService;
import com.example.web.service.ClientService;
import com.example.web.service.IBill;
import com.example.web.service.IClient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "ServletAddNewBill", value = "/ServletAddNewBill")
public class ServletAddNewBill extends HttpServlet {
    IClient iClient= new ClientService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session= request.getSession();
    String name = (String) session.getAttribute("client_name");
    if(name!=null){
    Bill bill= (Bill) session.getAttribute("bill");
    if(bill!=null){
        try {
        Client  client = iClient.findByName(name);
        client.setName(client.getName());
        client.setPhonenumber(client.getPhonenumber());
        client.setAddress(client.getAddress());
        int total= 0;
        List<Item> list = bill.getList();
        for (Item item:list
             ) {
            total+=item.getQuantity()*item.getProduct().getPrice();
        }
    String description="";
        boolean check=true;
        int i = 0;
        while(check==true){
            if(i<list.size()){
            description+="Tên sản phẩm: ";
            description += list.get(i).getProduct().getName()+" ";
            description+="Giá: ";
            description += list.get(i).getProduct().getPrice()+" ";
            description+="SL: ";
            description += list.get(i).getQuantity()+" ";
            description+=" ";
            i++;
        }else{
            check=false;
        }
        }
        IBill iBill = new BillService();
        iBill.insert(client,description,total);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.removeAttribute("bill");
        session.removeAttribute("estimate");
        session.removeAttribute("ship");
        response.sendRedirect("ServletCart");
    }else{
        response.sendRedirect("ServletProduct");
    }}
    else{
        response.sendRedirect("login.jsp");
    }
}
}