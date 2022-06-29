package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.Usuario;
import com.tcc.sospets.business.repositories.IUsuarioRepositorio;
import com.tcc.sospets.services.interfaces.IUsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsuarioService implements IUsuarioService {


    @Autowired
    IUsuarioRepositorio usuarioRepositorio;


    public List<Usuario> getUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario pegaUsuario(String usuarioId) {
        Usuario usuario = usuarioRepositorio.findById(usuarioId).orElse(null);
        return usuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void atualizaUsuario(Usuario usuario, String usuarioId) {
        Usuario usuarioAnterior = usuarioRepositorio.findById(usuarioId).orElse(null);
        usuarioRepositorio.save(usuarioAnterior);
      log.info("atualizou usuario");
    }

    @Override
    public void deletaUsuario(String usuarioId) {
        usuarioRepositorio.deleteById(usuarioId);
        log.info("deletou usuario");
    }
}
