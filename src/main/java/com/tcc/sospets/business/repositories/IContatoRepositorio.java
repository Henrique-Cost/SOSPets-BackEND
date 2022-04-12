package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IContatoRepositorio extends JpaRepository<Contato, String> {


}
