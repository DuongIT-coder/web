package com.example.web.service;

import com.example.web.enity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface IAdmin {
    List<Admin> getAll() throws SQLException;
    void edit(Admin admin) throws SQLException;
    void deleteById(int id) throws SQLException;
    Admin  findById(int id) throws SQLException;
    void insert(Admin admin) throws SQLException;
    Admin login(String email, String password) throws SQLException;
}
