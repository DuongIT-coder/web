package com.example.web.repos;

import com.example.web.enity.Product;
import com.example.web.enity.Service;
import com.example.web.util.ManagerConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicesRepository {
    public List<Service> getAll() throws SQLException {
        List<Service> list = new ArrayList<>();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query="select * from service";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            Service service = new Service();
            service.setId(resultSet.getInt("id"));
            service.setName(resultSet.getString("name"));
            service.setPrice(resultSet.getInt("price"));
            service.setImage(resultSet.getString("image"));
            service.setDescription(resultSet.getString("description"));
            list.add(service);
        }
        managerConnect.closeConnection();
        return list;
    }
    public Service findById(int id) throws SQLException {
        Service service = new Service();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="select * from service where id= '"+id+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            service.setId(resultSet.getInt("id"));
            service.setName(resultSet.getString("name"));
            service.setPrice(resultSet.getInt("price"));
            service.setImage(resultSet.getString("image"));
        }
        managerConnect.closeConnection();
        return service;
    }
    public void insert(Service service) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query="insert into service(name,price,image,description) values (?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1, service.getName());
        preparedStatement.setInt(2,service.getPrice());
        preparedStatement.setString(3,service.getImage());
        preparedStatement.setString(4,service.getDescription());
        preparedStatement.executeUpdate();
        managerConnect.closeConnection();
    }
    public void deleteById(int id) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="delete from service where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        managerConnect.closeConnection();
    }
    public void edit(Service service) throws SQLException {
        ManagerConnect managerConnect =new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String sql="update service set name = ?, price = ? , image = ? ,description= ? where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,service.getName());
        preparedStatement.setInt(2, service.getPrice());
        preparedStatement.setString(3, service.getImage());
        preparedStatement.setString(4, service.getDescription());
        preparedStatement.setInt(5,service.getId());
        preparedStatement.executeUpdate();
    }
}
