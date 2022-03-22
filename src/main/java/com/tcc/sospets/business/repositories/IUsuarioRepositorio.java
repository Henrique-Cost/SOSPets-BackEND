package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.Especie;
import com.tcc.sospets.business.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, String> {

    List<Usuario>findByUsuario(Usuario usuario);
}
