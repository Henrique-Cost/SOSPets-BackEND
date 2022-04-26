package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedbackRepositorio extends JpaRepository<Feedback, String> {


  }
