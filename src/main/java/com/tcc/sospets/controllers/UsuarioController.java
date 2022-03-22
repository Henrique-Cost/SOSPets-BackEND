package com.tcc.sospets.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.sospets.business.models.AnimalDomestico;
import com.tcc.sospets.business.models.Usuario;
import com.tcc.sospets.services.IAnimalDomesticoService;
import com.tcc.sospets.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/id_usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioServiceService;

    @GetMapping
    public List<Usuario> getUsuario() { return usuarioServiceService.getUsuario(); }

    @PostMapping
    public void saveUsuario (@RequestBody Usuario usuario){
        usuarioServiceService.saveUsuario(usuario);
    }

    @GetMapping("/{id_usuario}")
    public Usuario pegaUsuario(@PathVariable("id_usuario") String id_usuario){
        return usuarioServiceService.pegaUsuario(id_usuario);
    }

    @PutMapping("/{id_usuario}")
    public void atualizaUsuario(@PathVariable("id_usuario") String id_usuario, @RequestBody Usuario usuario){
        usuarioServiceService.atualizaUsuario(usuario, id_usuario);
    }

    @DeleteMapping("/{id_usuario}")
    public void deletaUsuario(@PathVariable("id_usuario") String id_usuario){
        usuarioServiceService.deletaUsuario(id_usuario);
    }

}
