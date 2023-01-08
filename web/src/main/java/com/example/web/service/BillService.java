package com.example.web.service;

import com.example.web.enity.Bill;
import com.example.web.enity.Client;
import com.example.web.repos.BillRepository;
import com.example.web.util.ManagerConnect;

import java.sql.SQLException;
import java.util.List;

public class BillService implements IBill{
    BillRepository billRepository = new BillRepository();

    @Override
    public void insert(Client client, String description, int total) throws SQLException {
        billRepository.insert(client,description,total);
    }

    @Override
    public List<Bill> getAll() throws SQLException {
        return billRepository.getAll();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        billRepository.deleteById(id);
    }
}
