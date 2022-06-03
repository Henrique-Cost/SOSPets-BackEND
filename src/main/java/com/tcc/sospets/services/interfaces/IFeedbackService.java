package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.Feedback;
import com.tcc.sospets.business.models.entities.User;

import java.util.List;

public interface IFeedbackService {

    List<Feedback> getFeedbacks();

    Feedback pegaFeedback(String feedbackId);

    void saveFeedback(Feedback feedback, User user);

    void atualizaFeedback(Feedback feedback, String feedbackId);

    void deletaFeedback(String feedbackId);
}
