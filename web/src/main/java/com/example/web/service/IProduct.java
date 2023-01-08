package com.example.web.service;

import com.example.web.enity.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    List<Product> getAll() throws SQLException;
    Product findById(int id) throws SQLException;
    void edit(Product product) throws SQLException;
    void deleteById(int id) throws SQLException;
    void insert(Product product) throws SQLException;
}
