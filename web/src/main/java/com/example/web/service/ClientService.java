package com.example.web.service;

import com.example.web.enity.Client;
import com.example.web.repos.ClientRepository;
import com.example.web.util.ManagerConnect;

import java.sql.SQLException;
import java.util.List;

public class ClientService implements IClient{
    ClientRepository clientRepository = new ClientRepository();
    @Override
    public Client login(String email, String password) throws SQLException {
        return clientRepository.login(email,password);
    }

    @Override
    public Client regist(Client client) throws SQLException {
        return clientRepository.regist(client);
    }

    @Override
    public List<Client> getAll() throws SQLException {
        return clientRepository.getAll();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(int id) throws SQLException {
        return clientRepository.findById(id);
    }

    @Override
    public Client findByEmail(String email) throws SQLException {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client findByName(String name) throws SQLException {
        return clientRepository.findByName(name);
    }
}
