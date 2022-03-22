package com.tcc.sospets.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.sospets.business.models.AnimalDomestico;
import com.tcc.sospets.services.IAnimalDomesticoService;
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
@RequestMapping("/animalDomestico")
public class AnimalDomesticoController {

    @Autowired
    IAnimalDomesticoService animalDomesticoService;

    @GetMapping
    public List<AnimalDomestico> getAnimaisDomesticos() {
        return animalDomesticoService.getAnimaisDomesticos();
    }

    @PostMapping
    public void saveAnimal(@RequestBody AnimalDomestico animalDomestico){
        animalDomesticoService.saveAnimal(animalDomestico);
    }

    @GetMapping("/{id_animalDomestico}")
    public AnimalDomestico pegaAnimal(@PathVariable("id_animalDomestico") String id_animalDomestico){
        return animalDomesticoService.pegaAnimal(id_animalDomestico);
    }

    @PutMapping("/{id_animalDomestico}")
    public void atualizaAnimal(@PathVariable("id_animalDomestico") String id_animalDomestico, @RequestBody AnimalDomestico animalDomestico){
        animalDomesticoService.atualizaAnimal(animalDomestico, id_animalDomestico);
    }

    @DeleteMapping("/{id_animalDomestico}")
    public void deletaAnimal(@PathVariable("id_animalDomestico") String id_animalDomestico){
        animalDomesticoService.deletaAnimal(id_animalDomestico);
    }

    @PostMapping(value = "/comFoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveAnimalComFoto(@RequestParam("animalDomestico") String animalDomestico, @RequestParam("foto")MultipartFile file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        AnimalDomestico novoAnimal = objectMapper.readValue(animalDomestico, AnimalDomestico.class);

        String fotoAnimal = UUID.randomUUID() + "_" + Long.toHexString(new Date().getTime());
        novoAnimal.setFotoAnimal(fotoAnimal + ".jpg");
        animalDomesticoService.saveAnimal(novoAnimal);

        Path filename = Paths.get("uploads").resolve(fotoAnimal);
    }
}
