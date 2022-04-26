package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.TipoUsuarioClasse;
import com.tcc.sospets.business.repositories.ITipoUsuarioRepositorio;
import com.tcc.sospets.services.interfaces.ITipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService implements ITipoUsuarioService {

    @Autowired
    ITipoUsuarioRepositorio tipoUsuarioRepositorio;

    @Override
    public List<TipoUsuarioClasse> getTiposUsuarios() {
        return tipoUsuarioRepositorio.findAll();
    }

    @Override
    public TipoUsuarioClasse pegaTipoUsuario(String tipoUsuarioId) {
        TipoUsuarioClasse tipoUsuarioClasse = tipoUsuarioRepositorio.findById(tipoUsuarioId).orElse(null);
        return tipoUsuarioClasse;
    }

    @Override
    public void saveTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse) {
        tipoUsuarioRepositorio.save(tipoUsuarioClasse);
    }

    @Override
    public void atualizaTipoUsuario(TipoUsuarioClasse tipoUsuarioClasse, String tipoUsuarioId) {
        TipoUsuarioClasse tipoUsuarioAnterior = tipoUsuarioRepositorio.findById(tipoUsuarioId).orElse(null);
        tipoUsuarioAnterior.setTipoDoUsuario(tipoUsuarioClasse.getTipoDoUsuario());
        tipoUsuarioRepositorio.save(tipoUsuarioAnterior);
    }

    @Override
    public void deletaTipoUsuario(String tipoUsuarioId) {
        tipoUsuarioRepositorio.deleteById(tipoUsuarioId);
    }
}
