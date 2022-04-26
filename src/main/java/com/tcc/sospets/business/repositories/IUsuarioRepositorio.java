package com.tcc.sospets.business.repositories;


import com.tcc.sospets.business.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, String> {


}
