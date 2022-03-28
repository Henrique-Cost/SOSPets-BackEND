package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Especie;
import com.tcc.sospets.business.models.Feedback;
import com.tcc.sospets.business.repositories.IFeedbackRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FeedbackService implements IFeedbackService {

    @Autowired
    IFeedbackRepositorio feedbackRepositorio;

    @Override
    public List<Feedback> getFeedback() {
        return feedbackRepositorio.findAll();
    }

    @Override
    public Feedback pegaFeedback(String id_feedback) {
        Feedback feedback = feedbackRepositorio.findById(id_feedback).orElse(null);
        return feedback;
    }

    @Override
    public void saveFeedback(Feedback feedback) { feedbackRepositorio.save(feedback);   }

    @Override
    public void atualizaFeedback(Feedback feedback, String id_feedback) {
        Feedback feedbackAnterior = feedbackRepositorio.findById(id_feedback).orElse(null);
        feedbackAnterior.setFeedback(feedback.getFeedback());
        feedbackRepositorio.save(feedback);
    }

    @Override
    public void deletaFeedback(String id_feedback) {
        feedbackRepositorio.deleteById(id_feedback);
    }
}
