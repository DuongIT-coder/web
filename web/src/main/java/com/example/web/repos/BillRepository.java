package com.example.web.repos;

import com.example.web.enity.Bill;
import com.example.web.enity.Client;
import com.example.web.enity.Product;
import com.example.web.util.ManagerConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    public List<Bill> getAll() throws SQLException {
        List<Bill>list =new ArrayList<>();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query="select * from bill";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            Bill bill = new Bill();
            Client client = new Client();
            client.setName(resultSet.getString("client_name"));
            client.setPhonenumber(resultSet.getString("phonenumber"));
            client.setAddress(resultSet.getString("address"));
            bill.setId(resultSet.getInt("id"));
            bill.setClient(client);
            bill.setDescription(resultSet.getString("description"));
            bill.setTotal(resultSet.getInt("total"));
            list.add(bill);
        }
        managerConnect.closeConnection();
        return list;
    }
    public void insert(Client client,String description,int total) throws SQLException {
        ManagerConnect managerConnect= new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="insert into bill(client_name,phonenumber,address,total,description) values(?,?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1,client.getName());
        preparedStatement.setString(2,client.getPhonenumber());
        preparedStatement.setString(3,client.getAddress());
        preparedStatement.setInt(4,total);
        preparedStatement.setString(5,description);
        preparedStatement.executeUpdate();
        managerConnect.closeConnection();
    }
    public void deleteById(int id) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="delete from bill where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        managerConnect.closeConnection();
    }
}
