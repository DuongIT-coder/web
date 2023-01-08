package com.example.web.service;

import com.example.web.enity.Feedback;

import java.sql.SQLException;
import java.util.List;

public interface IFeedback {
    List<Feedback> getAll() throws SQLException;
    void insert(Feedback feedback) throws SQLException;
    void deleteById(int id) throws SQLException;
    Feedback  findById(int id) throws SQLException;
    void edit(Feedback feedback) throws SQLException;
}
