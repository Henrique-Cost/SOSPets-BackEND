package com.tcc.sospets.services;
;
import com.tcc.sospets.business.models.Usuario;

import java.util.List;

public interface IUsuarioService {


    List<Usuario> getUsuarios();

    Usuario pegaUsuario(String id_usuario);

    void saveUsuario(Usuario usuario);

    void atualizaUsuario(Usuario usuario, String id_usuario);

    void deletaUsuario(String id_usuario);
}
