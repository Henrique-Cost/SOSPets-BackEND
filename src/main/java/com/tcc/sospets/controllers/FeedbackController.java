package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.Feedback;
import com.tcc.sospets.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/id_feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getFeedback() { return feedbackService.getFeedback(); }

    @PostMapping
    public void saveFeedback (@RequestBody Feedback feedback){
        feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/{id_feedback}")
    public Feedback pegaFeedback(@PathVariable("id_feedback") String id_feedback){
        return feedbackService.pegaFeedback(id_feedback);
    }

    @PutMapping("/{id_feedback}")
    public void atualizaFeedback(@PathVariable("id_feedback") String id_feedback, @RequestBody Feedback feedback){
        feedbackService.atualizaFeedback(feedback, id_feedback);
    }

    @DeleteMapping("/{id_feedback}")
    public void deletaFeedback(@PathVariable("id_feedback") Feedback id_feedback){
        feedbackService.deletaFeedback(String.valueOf(id_feedback));
    }
}
