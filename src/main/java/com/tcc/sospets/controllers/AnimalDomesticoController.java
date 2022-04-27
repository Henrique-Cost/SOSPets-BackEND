package com.tcc.sospets.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.sospets.business.models.entities.AnimalDomestico;
import com.tcc.sospets.services.classes.AnimalDomesticoService;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    AnimalDomesticoService animalDomesticoService;

    @GetMapping
    public List<AnimalDomestico> getAnimaisDomesticos() {
        return animalDomesticoService.getAnimaisDomesticos();
    }

    @PostMapping
    public void saveAnimal(@RequestBody AnimalDomestico animalDomestico){
        animalDomesticoService.saveAnimal(animalDomestico);
    }

    @GetMapping("/{animalDomesticoId}")
    public AnimalDomestico pegaAnimal(@PathVariable("animalDomesticoId") String animalDomesticoId){
        return animalDomesticoService.pegaAnimal(animalDomesticoId);
    }

    @PutMapping("/{animalDomesticoId}")
    public void atualizaAnimal(@PathVariable("animalDomesticoId") String animalDomesticoId, @RequestBody AnimalDomestico animalDomestico){
        animalDomesticoService.atualizaAnimal(animalDomestico, animalDomesticoId);
    }

    @DeleteMapping("/{animalDomesticoId}")
    public void deletaAnimal(@PathVariable("animalDomesticoId") String animalDomesticoId){
        animalDomesticoService.deletaAnimal(animalDomesticoId);
    }

    @PostMapping(value = "/comFoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveAnimalComFoto(@RequestParam("animalDomestico") String animalDomestico, @RequestParam("foto")MultipartFile file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        AnimalDomestico novoAnimal = objectMapper.readValue(animalDomestico, AnimalDomestico.class);

        String fotoAnimal = UUID.randomUUID() + "_" + Long.toHexString(new Date().getTime());
        novoAnimal.setFotoAnimal(fotoAnimal + ".jpg");
        animalDomesticoService.saveAnimal(novoAnimal);

        Path filename = Paths.get("uploads").resolve(fotoAnimal);

        Path thumbFilename = Paths.get("uploads").resolve("thumb_" + fotoAnimal);
        Thumbnails.of(file.getInputStream())
                .size(500, 500)
                .outputFormat("jpg")
                .toFile(new File(filename.toString()));
        Thumbnails.of(file.getInputStream())
                .size(100, 100)
                .outputFormat("jpg")
                .toFile(new File(thumbFilename.toString()));
    }
}
