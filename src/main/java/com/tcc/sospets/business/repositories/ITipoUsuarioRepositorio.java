package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.TipoUsuarioClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoUsuarioRepositorio extends JpaRepository<TipoUsuarioClasse, String> {


}
