package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.Feedback;

import java.util.List;

public interface IFeedbackService {

    List<Feedback> getFeedbacks();

    Feedback pegaFeedback(String feedbackId);

    void saveFeedback(Feedback feedback);

    void atualizaFeedback(Feedback feedback, String feedbackId);

    void deletaFeedback(String feedbackId);
}
