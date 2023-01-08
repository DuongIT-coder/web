package com.example.web.repos;

import com.example.web.enity.Product;
import com.example.web.util.ManagerConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
     public List<Product> getAll() throws SQLException {
        List<Product>list =new ArrayList<>();
         ManagerConnect managerConnect = new ManagerConnect();
         Connection connection = managerConnect.openConnection();
         String query="select * from product";
         Statement statement = connection.createStatement();
         ResultSet resultSet= statement.executeQuery(query);
         while(resultSet.next()){
             Product product= new Product();
             product.setId(resultSet.getInt("id"));
             product.setName(resultSet.getString("name"));
             product.setPrice(resultSet.getInt("price"));
             product.setImage(resultSet.getString("image"));
             list.add(product);
         }
         managerConnect.closeConnection();
        return list;
    }
    public void edit(Product product) throws SQLException {
        ManagerConnect managerConnect =new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String sql="update product set name = ? , image = ? ,price= ? where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2, product.getImage());
        preparedStatement.setInt(3, product.getPrice());
        preparedStatement.setInt(4,product.getId());
        preparedStatement.executeUpdate();
    }
    public void deleteById(int id) throws SQLException {
         ManagerConnect managerConnect = new ManagerConnect();
         Connection connection= managerConnect.openConnection();
         String query="delete from product where id = ? ";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1,id);
         preparedStatement.executeUpdate();
    }
    public Product  findById(int id) throws SQLException {
         Product product = new Product();
         ManagerConnect managerConnect = new ManagerConnect();
         Connection connection= managerConnect.openConnection();
         String query="select * from product where id= '"+id+"'";
         Statement statement = connection.createStatement();
         ResultSet resultSet= statement.executeQuery(query);
         while(resultSet.next()){
             product.setId(resultSet.getInt("id"));
             product.setName(resultSet.getString("name"));
             product.setPrice(resultSet.getInt("price"));
             product.setImage(resultSet.getString("image"));
         }
         managerConnect.closeConnection();
         return product;
    }
    public void insert(Product product) throws SQLException {
         ManagerConnect managerConnect = new ManagerConnect();
         Connection connection = managerConnect.openConnection();
        String query="insert into product(name,price,image) values (?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2,product.getPrice());
        preparedStatement.setString(3,product.getImage());
        preparedStatement.executeUpdate();
    }
    }
