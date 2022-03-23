package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFeedbackRepositorio extends JpaRepository<Feedback, String> {

    List<Feedback>findByFeedback(Feedback feedback);

  }
