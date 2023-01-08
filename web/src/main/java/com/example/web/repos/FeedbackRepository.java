package com.example.web.repos;

import com.example.web.enity.Feedback;
import com.example.web.enity.Product;
import com.example.web.util.ManagerConnect;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {


    public List<Feedback> getAll() throws SQLException {
        ManagerConnect managerConnect= new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        List<Feedback> list = new ArrayList<>();
        Statement statement= connection.createStatement();
        String query="select * from feedback";
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            Feedback feedback= new Feedback();
            feedback.setId(resultSet.getInt("id"));
            feedback.setClient_name(resultSet.getString("client_name"));
            feedback.setFeedback(resultSet.getString("feedback"));
            feedback.setImage(resultSet.getString("image"));
            list.add(feedback);
        }
        managerConnect.closeConnection();
        return list;
    }
    public void insert(Feedback feedback) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection = managerConnect.openConnection();
        String query="insert into feedback(client_name,feedback,image) values (?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1, feedback.getClient_name());
        preparedStatement.setString(2,feedback.getFeedback());
        preparedStatement.setString(3,feedback.getImage());
        preparedStatement.executeUpdate();
    }
    public Feedback  findById(int id) throws SQLException {
        Feedback feedback = new Feedback();
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="select * from feedback where id= '"+id+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        while(resultSet.next()){
            feedback.setId(resultSet.getInt("id"));
            feedback.setClient_name(resultSet.getString("client_name"));
            feedback.setFeedback(resultSet.getString("feedback"));
            feedback.setImage(resultSet.getString("image"));
        }
        managerConnect.closeConnection();
        return feedback;
    }
    public void deleteById(int id) throws SQLException {
        ManagerConnect managerConnect = new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String query="delete from feedback where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
    public void edit(Feedback feedback) throws SQLException {
        ManagerConnect managerConnect =new ManagerConnect();
        Connection connection= managerConnect.openConnection();
        String sql="update feedback set client_name = ? , feedback = ? , image = ?  where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,feedback.getClient_name());
        preparedStatement.setString(2, feedback.getFeedback());
        preparedStatement.setString(3, feedback.getImage());
        preparedStatement.setInt(4,feedback.getId());
        preparedStatement.executeUpdate();
    }
}
