package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.Feedback;
import com.tcc.sospets.business.repositories.IFeedbackRepositorio;
import com.tcc.sospets.services.interfaces.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    IFeedbackRepositorio feedbackRepositorio;

    @Override
    public List<Feedback> getFeedbacks() {
        return feedbackRepositorio.findAll();
    }

    @Override
    public Feedback pegaFeedback(String feedbackId) {
        Feedback feedback = feedbackRepositorio.findById(feedbackId).orElse(null);
        return feedback;
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackRepositorio.save(feedback);
    }

    @Override
    public void atualizaFeedback(Feedback feedback, String feedbackId) {
        Feedback feedbackAnterior = feedbackRepositorio.findById(feedbackId).orElse(null);
        feedbackAnterior.setFeedback(feedback.getFeedback());
        feedbackRepositorio.save(feedback);
    }

    @Override
    public void deletaFeedback(String feedbackId) {
        feedbackRepositorio.deleteById(feedbackId);
    }
}