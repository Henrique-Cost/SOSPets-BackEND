package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.TipoUsuarioClasse;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ITipoUsuarioRepositorio extends JpaRepository<TipoUsuarioClasse, String> {


}
