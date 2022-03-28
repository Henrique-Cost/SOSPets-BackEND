package com.tcc.sospets.services;

import com.tcc.sospets.business.models.TipoUsuarioClasse;

import java.util.List;

public interface ITipoUsuarioService {

    List<TipoUsuarioClasse> getTiposUsuarios();

    TipoUsuarioClasse pegaTipoUsuario(String id_tipo_usuario);

    void saveTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse);

    void atualizaTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse, String id_tipo_usuario);

    void deletaTipoUsuario(String id_tipo_usuario);
}
