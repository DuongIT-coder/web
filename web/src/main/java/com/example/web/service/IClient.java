package com.example.web.service;

import com.example.web.enity.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClient {
Client login(String email,String password) throws SQLException;
Client regist(Client client) throws SQLException;
    List<Client> getAll() throws SQLException;
void deleteById(int id) throws SQLException;
Client findById(int id) throws SQLException;
    Client findByEmail(String email) throws SQLException;
    Client findByName(String name) throws SQLException;
}
