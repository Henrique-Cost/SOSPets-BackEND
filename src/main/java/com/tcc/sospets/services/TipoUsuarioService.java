package com.tcc.sospets.services;

import com.tcc.sospets.business.models.TipoUsuarioClasse;
import com.tcc.sospets.business.repositories.ITipoUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService implements ITipoUsuarioService{

    @Autowired
    ITipoUsuarioRepositorio tipoUsuarioRepositorio;

    @Override
    public List<TipoUsuarioClasse> getTiposUsuarios() {
        return tipoUsuarioRepositorio.findAll();
    }

    @Override
    public TipoUsuarioClasse pegaTipoUsuario(String id_tipo_usuario) {
        TipoUsuarioClasse tipoUsuarioClasse = tipoUsuarioRepositorio.findById(id_tipo_usuario).orElse(null);
        return tipoUsuarioClasse;
    }

    @Override
    public void saveTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse) {
        tipoUsuarioRepositorio.save(tipoUsuarioClasse);
    }

    @Override
    public void atualizaTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse, String id_tipo_usuario) {
        TipoUsuarioClasse tipoUsuarioAnterior = tipoUsuarioRepositorio.findById(id_tipo_usuario).orElse(null);
        tipoUsuarioAnterior.setTipo_usuario(tipoUsuarioClasse.getTipo_usuario());
        tipoUsuarioRepositorio.save(tipoUsuarioAnterior);
    }

    @Override
    public void deletaTipoUsuario(String id_tipo_usuario) {
        tipoUsuarioRepositorio.deleteById(id_tipo_usuario);
    }
}
