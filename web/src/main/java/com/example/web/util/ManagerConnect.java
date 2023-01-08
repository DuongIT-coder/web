package com.example.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManagerConnect {
    Connection connection = null;
    public Connection openConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_web", "root", "duongbarber1");
            System.out.println("Kết nối thành công!!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
