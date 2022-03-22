package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Especie;
import com.tcc.sospets.business.models.Usuario;
import com.tcc.sospets.business.repositories.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService implements IUsuarioService{


    @Autowired
    IUsuarioRepositorio usuarioRepositorio;


    public List<Usuario> getUsuario() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario pegaUsuario(String id_usuario) {
        Usuario usuario = usuarioRepositorio.findById(id_usuario).orElse(null);
        return usuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void atualizaUsuario(Usuario usuario, String id_usuario) {
        Usuario usuarioAnterior = usuarioRepositorio.findById(id_usuario).orElse(null);
        usuarioAnterior.setId_usuario(usuario.getId_usuario());
        usuarioRepositorio.save(usuarioAnterior);
    }

    @Override
    public void deletaUsuario(String id_usuario) {
        usuarioRepositorio.deleteById(id_usuario);
    }
}

