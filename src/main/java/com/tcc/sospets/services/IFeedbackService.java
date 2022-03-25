package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Especie;
import com.tcc.sospets.business.models.Feedback;

import java.util.List;

public interface IFeedbackService {

    List<Feedback> getFeedbacks();

    Feedback pegaFeedback(String id_feedback);

    void saveFeedback(Feedback feedback);

    void atualizaFeedback(Feedback feedback, String id_feedback);

    void deletaFeedback(String id_feedback);
}
