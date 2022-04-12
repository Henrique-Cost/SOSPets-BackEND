package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.TipoUsuarioClasse;
import com.tcc.sospets.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public List<TipoUsuarioClasse> getTiposUsuarios(){
        return tipoUsuarioService.getTiposUsuarios();
    }

    @GetMapping("/{id_tipo_usuario}")
    public TipoUsuarioClasse pegaTipoUsuario(@PathVariable("id_tipo_usuario") String id_tipo_usuario){
        return tipoUsuarioService.pegaTipoUsuario(id_tipo_usuario);
    }

    @PostMapping("/{id_tipo_usuario}")
    public void saveTipoUsuario(@RequestBody TipoUsuarioClasse tipoUsuarioClasse){
        tipoUsuarioService.saveTipoUsuario(tipoUsuarioClasse);
    }

    @PutMapping("/{id_tipo_usuario}")
    public void atualizaTipoUsuario(@PathVariable("id_tipo_usuario") String id_tipo_usuario, @RequestBody TipoUsuarioClasse tipoUsuarioClasse){
        tipoUsuarioService.atualizaTipoUsuario(tipoUsuarioClasse, id_tipo_usuario);
    }

    @DeleteMapping("/{id_tipo_usuario}")
    public void deletaTipoUsuario(@PathVariable("id_tipo_usuario") String id_tipo_usuario){
        tipoUsuarioService.deletaTipoUsuario(id_tipo_usuario);
    }
}
