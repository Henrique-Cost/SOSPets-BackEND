package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.entities.TipoUsuarioClasse;
import com.tcc.sospets.services.classes.TipoUsuarioService;
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

    @GetMapping("/{tipoUsuarioId}")
    public TipoUsuarioClasse pegaTipoUsuario(@PathVariable("tipoUsuarioId") String tipoUsuarioId){
        return tipoUsuarioService.pegaTipoUsuario(tipoUsuarioId);
    }

    @PostMapping("/{tipoUsuarioId}")
    public void saveTipoUsuario(@RequestBody TipoUsuarioClasse tipoUsuarioClasse){
        tipoUsuarioService.saveTipoUsuario(tipoUsuarioClasse);
    }

    @PutMapping("/{tipoUsuarioId}")
    public void atualizaTipoUsuario(@PathVariable("tipoUsuarioId") String tipoUsuarioId, @RequestBody TipoUsuarioClasse tipoUsuarioClasse){
        tipoUsuarioService.atualizaTipoUsuario(tipoUsuarioClasse, tipoUsuarioId);
    }

    @DeleteMapping("/{tipoUsuarioId}")
    public void deletaTipoUsuario(@PathVariable("tipoUsuarioId") String tipoUsuarioId){
        tipoUsuarioService.deletaTipoUsuario(tipoUsuarioId);
    }
}
