package com.example.web.service;

import com.example.web.enity.Admin;
import com.example.web.repos.AdminRepository;

import java.sql.SQLException;
import java.util.List;

public class AdminService implements IAdmin{
    AdminRepository adminRepository = new AdminRepository();
    @Override
    public List<Admin> getAll() throws SQLException {
        return adminRepository.getAll();
    }

    @Override
    public void edit(Admin admin) throws SQLException {
        adminRepository.edit(admin);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin findById(int id) throws SQLException {
        return adminRepository.findById(id);
    }

    @Override
    public void insert(Admin admin) throws SQLException {
        adminRepository.insert(admin);
    }

    @Override
    public Admin login(String email, String password) throws SQLException {
        return adminRepository.login(email,password);
    }
}
