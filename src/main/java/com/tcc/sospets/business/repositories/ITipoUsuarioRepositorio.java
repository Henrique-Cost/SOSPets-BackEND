package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.TipoUsuarioClasse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITipoUsuarioRepositorio extends JpaRepository<TipoUsuarioClasse, String> {

    List<TipoUsuarioClasse> findByTipo(TipoUsuarioClasse tipoUsuarioClasse);
}
