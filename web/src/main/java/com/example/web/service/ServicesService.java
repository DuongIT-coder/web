package com.example.web.service;

import com.example.web.enity.Service;
import com.example.web.repos.ServicesRepository;

import java.sql.SQLException;
import java.util.List;

public class ServicesService implements IServices{
    private ServicesRepository servicesRepository= new ServicesRepository();
    @Override
    public List<Service> getAll() throws SQLException {
        return servicesRepository.getAll();
    }

    @Override
    public Service findById(int id) throws SQLException {
        return servicesRepository.findById(id);
    }

    @Override
    public void edit(Service service) throws SQLException {
        servicesRepository.edit(service);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        servicesRepository.deleteById(id);
    }

    @Override
    public void insert(Service service) throws SQLException {
        servicesRepository.insert(service);
    }
}
