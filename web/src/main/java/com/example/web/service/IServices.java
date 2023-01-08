package com.example.web.service;

import com.example.web.enity.Product;
import com.example.web.enity.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServices {
    List<Service> getAll() throws SQLException;
    Service findById(int id) throws SQLException;
    void edit(Service service) throws SQLException;
    void deleteById(int id) throws SQLException;
    void insert(Service service) throws SQLException;
}
