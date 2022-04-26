package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IFeedbackRepositorio extends JpaRepository<Feedback, String> {


  }
