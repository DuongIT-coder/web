package com.example.web.repos;

import com.example.web.enity.Client;
import com.example.web.enity.Product;
import com.example.web.util.ManagerConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    ManagerConnect managerConnect = new ManagerConnect();

    public Client login(String email, String password) throws SQLException {
        List<Client> list = new ArrayList<>();
        Connection connection = managerConnect.openConnection();
        String query = "select * from client where email = ? and password = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        Client client = new Client();
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            client.setName(resultSet.getString("name"));
            client.setEmail(resultSet.getString("email"));
            break;
        }
        managerConnect.closeConnection();
        return client;
    }

    public Client regist(Client client) throws SQLException {
        Connection connection = managerConnect.openConnection();
        String query = "insert into client(name,email,password,address,phonenumber) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getEmail());
        preparedStatement.setString(3, client.getPassword());
        preparedStatement.setString(4, client.getAddress());
        preparedStatement.setString(5, client.getPhonenumber());
        preparedStatement.executeUpdate();
        managerConnect.closeConnection();
        return client;
    }
    public List<Client> getAll() throws SQLException {
        List<Client>list =new ArrayList<>();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query="select * from client";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setEmail(resultSet.getString("email"));
            client.setPassword(resultSet.getString("password"));
            list.add(client);
        }
        managerConnect.closeConnection();
        return list;
    }
    public void deleteById(int id) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="delete from client where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
    public Client  findById(int id) throws SQLException {
        Client client = new Client();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="select * from client where id= '"+id+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setAddress(resultSet.getString("address"));
            client.setPhonenumber(resultSet.getString("phonenumber"));
            client.setEmail(resultSet.getString("email"));
            client.setPassword(resultSet.getString("password"));
        }
        managerConnect.closeConnection();
        return client;
    }
    public Client  findByEmail(String email) throws SQLException {
        Client client = new Client();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="select * from client where email= '"+email+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setAddress(resultSet.getString("address"));
            client.setPhonenumber(resultSet.getString("phonenumber"));
            client.setEmail(resultSet.getString("email"));
            client.setPassword(resultSet.getString("password"));
        }
        managerConnect.closeConnection();
        return client;
    }
    public Client  findByName(String name) throws SQLException {
        Client client = new Client();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="select * from client where name= '"+name+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setAddress(resultSet.getString("address"));
            client.setPhonenumber(resultSet.getString("phonenumber"));
            client.setEmail(resultSet.getString("email"));
            client.setPassword(resultSet.getString("password"));
        }
        managerConnect.closeConnection();
        return client;
    }
}



