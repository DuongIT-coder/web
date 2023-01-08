package com.example.web.service;

import com.example.web.enity.Product;
import com.example.web.repos.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProduct{
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> getAll() throws SQLException {
        return productRepository.getAll();
    }

    @Override
    public Product findById(int id) throws SQLException {
        return productRepository.findById(id);
    }

    @Override
    public void edit(Product product) throws SQLException {
        productRepository.edit(product);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        productRepository.deleteById(id);
    }

    @Override
    public void insert(Product product) throws SQLException {
        productRepository.insert(product);
    }



}
