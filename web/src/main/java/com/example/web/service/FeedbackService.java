package com.example.web.service;

import com.example.web.enity.Feedback;
import com.example.web.repos.FeedbackRepository;

import java.sql.SQLException;
import java.util.List;

public class FeedbackService implements IFeedback{
    FeedbackRepository feedbackRepository = new FeedbackRepository();
    @Override
    public List<Feedback> getAll() throws SQLException {
        return feedbackRepository.getAll();
    }

    @Override
    public void insert(Feedback feedback) throws SQLException {
        feedbackRepository.insert(feedback);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Feedback findById(int id) throws SQLException {
        return feedbackRepository.findById(id);
    }

    @Override
    public void edit(Feedback feedback) throws SQLException {
        feedbackRepository.edit(feedback);
    }
}
