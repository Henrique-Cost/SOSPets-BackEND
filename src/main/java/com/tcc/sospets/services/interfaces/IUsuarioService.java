package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.Usuario;

import java.util.List;

public interface IUsuarioService {


    List<Usuario> getUsuarios();

    Usuario pegaUsuario(String usuarioId);

    void saveUsuario(Usuario usuario);

    void atualizaUsuario(Usuario usuario, String usuarioId);

    void deletaUsuario(String usuarioId);
}
