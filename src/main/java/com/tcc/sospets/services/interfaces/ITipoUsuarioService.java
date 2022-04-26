package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.TipoUsuarioClasse;

import java.util.List;

public interface ITipoUsuarioService {

    List<TipoUsuarioClasse> getTiposUsuarios();

    TipoUsuarioClasse pegaTipoUsuario(String tipoUsuarioId);

    void saveTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse);

    void atualizaTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse, String tipoUsuarioId);

    void deletaTipoUsuario(String tipoUsuarioId);
}
