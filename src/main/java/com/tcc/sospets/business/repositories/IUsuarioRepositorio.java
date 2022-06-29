package com.tcc.sospets.business.repositories;


import com.tcc.sospets.business.models.entities.User;
import com.tcc.sospets.business.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByUser(User user);

}
