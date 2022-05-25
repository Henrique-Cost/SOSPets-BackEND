package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.entities.Usuario;
import com.tcc.sospets.services.classes.UsuarioService;
import com.tcc.sospets.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

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

    @PutMapping("/{usuarioId}")
    public void atualizaUsuario(@PathVariable("usuarioId") String usuarioId, @RequestBody Usuario usuario){
        usuarioService.atualizaUsuario(usuario, usuarioId);
    }

    @DeleteMapping("/{usuarioId}")
    public void deletaUsuario(@PathVariable("usuarioId") String usuarioId){
        usuarioService.deletaUsuario(usuarioId);
    }

}


