package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.Contato;
import com.tcc.sospets.business.models.CorAnimal;
import com.tcc.sospets.services.CorAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corAnimal")
public class CorAnimalController {

    @Autowired
    CorAnimalService corAnimalService;

    @GetMapping
    public List<CorAnimal> getCores() {
        return corAnimalService.getCores();
    }

    @GetMapping("/{id_cor}")
    public CorAnimal pegaCorAnimal(@PathVariable("id_cor") String id_cor){
        return corAnimalService.pegaCorAnimal(id_cor);
    }

    @PostMapping
    public void saveCorAnimal(@RequestBody CorAnimal corAnimal) {
        corAnimalService.saveCorAnimal(corAnimal);
    }

    @PutMapping("/{id_cor}")
    public void atualizaCorAnimal(@PathVariable("id_cor") String id_cor, @RequestBody CorAnimal corAnimal){
        corAnimalService.atualizaCorAnimal(corAnimal, id_cor);
    }

    @DeleteMapping("/{id_cor}")
    public void deletaCorAnimal(@PathVariable("id_cor") String id_cor) {
        corAnimalService.deletaCorAnimal(id_cor);
    }


}
