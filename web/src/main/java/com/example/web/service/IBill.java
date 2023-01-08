package com.example.web.service;

import com.example.web.enity.Bill;
import com.example.web.enity.Client;

import java.sql.SQLException;
import java.util.List;

public interface IBill {
    void insert(Client client,String description,int total) throws SQLException;
    List<Bill> getAll() throws SQLException;
    void deleteById(int id) throws SQLException;
}
