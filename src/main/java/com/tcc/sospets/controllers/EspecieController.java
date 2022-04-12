package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.Especie;
import com.tcc.sospets.services.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especie")
public class EspecieController {

    @Autowired
    EspecieService especieService;

    @GetMapping
    public List<Especie> getEspecies(){
        return especieService.getEspecies();
    }

    @GetMapping("/{id_especie}")
    public Especie pegaEspecies(@PathVariable("id_especie") String id_especie){
        return especieService.pegaEspecie(id_especie);
    }

    @PostMapping("/{id_especie}")
    public void saveEspecie(@RequestBody String id_especie) {
        especieService.pegaEspecie(id_especie);
    }

    @PutMapping("/{id_especie}")
    public void atualizaEspecie(@PathVariable("id_especie") String id_especie, @RequestBody Especie especie){
        especieService.atualizaEspecie(especie, id_especie);
    }

    @DeleteMapping("/{id_especie}")
    public void deletaEspecie(@PathVariable("id_especie") String id_especie){
        especieService.deletaEspecie(id_especie);
    }

}
