package com.example.web.repos;

import com.example.web.enity.Admin;
import com.example.web.enity.Client;
import com.example.web.enity.Product;
import com.example.web.util.ManagerConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    public List<Admin> getAll() throws SQLException {
        List<Admin>list =new ArrayList<>();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query="select * from admin";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            Admin admin= new Admin();
            admin.setId(resultSet.getInt("id"));
            admin.setName(resultSet.getString("name"));
            admin.setEmail(resultSet.getString("email"));
            admin.setPassword(resultSet.getString("password"));
            admin.setAddress(resultSet.getString("address"));
            list.add(admin);
        }
        managerConnect.closeConnection();
        return list;
    }
    public void edit(Admin admin) throws SQLException {
        ManagerConnect managerConnect =new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String sql="update admin set name = ? , address = ? ,email= ?,password=? where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,admin.getName());
        preparedStatement.setString(2, admin.getAddress());
        preparedStatement.setString(3, admin.getEmail());
        preparedStatement.setString(4,admin.getPassword());
        preparedStatement.setInt(5,admin.getId());
        preparedStatement.executeUpdate();
    }
    public void deleteById(int id) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="delete from admin where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
    public Admin  findById(int id) throws SQLException {
        Admin admin = new Admin();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="select * from admin where id= '"+id+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            admin.setId(resultSet.getInt("id"));
            admin.setName(resultSet.getString("name"));
            admin.setAddress(resultSet.getString("address"));
            admin.setEmail(resultSet.getString("email"));
            admin.setPassword(resultSet.getString("password"));
        }
        managerConnect.closeConnection();
        return admin;
    }
    public void insert(Admin admin) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query="insert into admin(name,address,email,password) values (?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1, admin.getName());
        preparedStatement.setString(2,admin.getAddress());
        preparedStatement.setString(3,admin.getEmail());
        preparedStatement.setString(3,admin.getPassword());
        preparedStatement.executeUpdate();
    }
    public Admin login(String email, String password) throws SQLException {
        List<Admin> list = new ArrayList<>();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query = "select * from admin where email = ? and password = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        Admin admin = new Admin();
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            admin.setName(resultSet.getString("name"));
            admin.setEmail(resultSet.getString("email"));
            break;
        }
        managerConnect.closeConnection();
        return admin;
    }
    }
