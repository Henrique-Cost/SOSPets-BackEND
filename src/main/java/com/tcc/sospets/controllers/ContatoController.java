package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.Contato;
import com.tcc.sospets.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/id_contato")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @GetMapping
    public List<Contato> getContato() { return contatoService.getContato(); }

    @PostMapping
    public void saveContato (@RequestBody Contato contato){
        contatoService.saveContato(contato);
    }

    @GetMapping("/{id_contato}")
    public Contato pegaContato(@PathVariable("id_contato") String id_contato){
        return contatoService.pegaContato(id_contato);
    }

    @PutMapping("/{id_contato}")
    public void atualizaContato(@PathVariable("id_contato") String id_contato, @RequestBody Contato contato){
        contatoService.atualizaContato(contato, id_contato);
    }

    @DeleteMapping("/{id_contato}")
    public void deletaUsuario(@PathVariable("id_contato") Contato id_contato){
        contatoService.deletaContato(id_contato);
    }

}

