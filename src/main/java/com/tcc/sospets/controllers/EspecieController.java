package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.entities.Especie;
import com.tcc.sospets.services.classes.EspecieService;
import com.tcc.sospets.services.interfaces.IEspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especie")
public class EspecieController {

    @Autowired
    IEspecieService especieService;

    @GetMapping
    public List<Especie> getEspecies(){
        return especieService.getEspecies();
    }

    @GetMapping("/{especieId}")
    public Especie pegaEspecies(@PathVariable("especieId") String especieId){
        return especieService.pegaEspecie(especieId);
    }

    @PostMapping("/{especieId}")
    public void saveEspecie(@RequestBody String especieId) {
        especieService.pegaEspecie(especieId);
    }

    @PutMapping("/{especieId}")
    public void atualizaEspecie(@PathVariable("especieId") String especieId, @RequestBody Especie especie){
        especieService.atualizaEspecie(especie, especieId);
    }

    @DeleteMapping("/{especieId}")
    public void deletaEspecie(@PathVariable("especieId") String especieId){
        especieService.deletaEspecie(especieId);
    }

}
