package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.Feedback;
import com.tcc.sospets.business.models.entities.User;
import com.tcc.sospets.business.models.entities.Usuario;
import com.tcc.sospets.business.repositories.IFeedbackRepositorio;
import com.tcc.sospets.business.repositories.IUsuarioRepositorio;
import com.tcc.sospets.services.interfaces.IFeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    IUsuarioRepositorio usuarioRepositorio;
    @Autowired
    IFeedbackRepositorio feedbackRepositorio;

    @Override
    public List<Feedback> getFeedbacks() {
        return feedbackRepositorio.findAll();
    }

    @Override
    public Feedback pegaFeedback(String feedbackId) {
        log.info("Usuario com o id fez um feedback");
        Feedback feedback = feedbackRepositorio.findById(feedbackId).orElse(null);
        return feedback;

    }

    @Override
    public void saveFeedback(Feedback feedback, User user) {
        Usuario usuario = usuarioRepositorio.findByUser(user).orElseThrow();
        feedback.setUsuario(usuario);
        feedbackRepositorio.save(feedback);
    }

    @Override
    public void atualizaFeedback(Feedback feedback, String feedbackId) {
        Feedback feedbackAnterior = feedbackRepositorio.findById(feedbackId).orElse(null);
        feedbackAnterior.setSugestao(feedback.getSugestao());
        feedbackRepositorio.save(feedback);
    }

    @Override
    public void deletaFeedback(String feedbackId) {
        feedbackRepositorio.deleteById(feedbackId);
    }
}