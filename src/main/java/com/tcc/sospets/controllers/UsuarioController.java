package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.entities.User;
import com.tcc.sospets.business.models.entities.Usuario;
import com.tcc.sospets.business.repositories.IUsuarioRepositorio;
import com.tcc.sospets.services.interfaces.IUsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    @GetMapping
    public List<Usuario> getUsuario() { return usuarioService.getUsuarios(); }

    @PostMapping
    public void saveUsuario (@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/{usuarioId}")
    public Usuario pegaUsuario(@PathVariable("usuarioId") String usuarioId){
        return usuarioService.pegaUsuario(usuarioId);
    }

    @GetMapping("/usuario/own")
    public Usuario pegaMeuUsuario(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return usuarioRepositorio.findByUser(user).orElseThrow();
    }

    @PutMapping("/{usuarioId}")
    public void atualizaUsuario(@PathVariable("usuarioId") String usuarioId, @RequestBody Usuario usuario){
        usuarioService.atualizaUsuario(usuario, usuarioId);
    }

    @DeleteMapping("/{usuarioId}")
    public void deletaUsuario(@PathVariable("usuarioId") String usuarioId){
        usuarioService.deletaUsuario(usuarioId);
    }

}


