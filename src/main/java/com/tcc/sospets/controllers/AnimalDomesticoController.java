package com.tcc.sospets.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.sospets.business.models.dto.AnimalDomesticoRequest;
import com.tcc.sospets.business.models.dto.AnimalDomesticoResponse;
import com.tcc.sospets.business.models.dto.PageAnimalDomesticoResponse;
import com.tcc.sospets.business.models.entities.*;

import com.tcc.sospets.business.repositories.IAnimalDomesticoRepositorio;
import com.tcc.sospets.services.interfaces.IAnimalDomesticoService;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/animaldomestico")
public class AnimalDomesticoController {

    @Autowired
    IAnimalDomesticoService animalDomesticoService;

    @Autowired
    IAnimalDomesticoRepositorio animalDomesticoRepositorio;

    @GetMapping
    public PageAnimalDomesticoResponse getAnimaisDomesticos(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize){
        Page<AnimalDomestico> animais = animalDomesticoService.getAnimaisDomesticos(page, pageSize);
        List<AnimalDomesticoResponse> animalDomesticoResponseList = animais.stream()
                .map(animalDomestico -> AnimalDomesticoResponse.builder()
                        .acessorio(animalDomestico.getAcessorio())
                        .localizacao(animalDomestico.getLocalizacao())
                        .fotoAnimal(animalDomestico.getFotoAnimal())
                        .cor(animalDomestico.getCor())
                        .condicaoAnimal(animalDomestico.getCondicaoAnimal())
                        .genero(animalDomestico.getGenero())
                        .porte(animalDomestico.getPorte())
                        .tipoUsuario(animalDomestico.getTipoUsuario())
                        .build()
                ).collect(Collectors.toList());
        return PageAnimalDomesticoResponse.builder()
                .animais(animalDomesticoResponseList)
                .totalPages(animais.getTotalPages()).build();
    }

    @GetMapping("/query")
    public List<AnimalDomestico> buscaAnimal(@RequestParam("porte") PorteEnum porte,
                                                 @RequestParam("especie") EspecieEnum especie,
                                                 @RequestParam("cor") CorEnum cor,
                                                 @RequestParam("acessorio") String acessorio,
                                                 @RequestParam("condicaoAnimal") CondicaoAnimalEnum condicaoAnimal,
                                                 @RequestParam("genero") GeneroEnum genero)
    {
        return animalDomesticoService.buscaAnimal(porte, especie, cor, acessorio, condicaoAnimal, genero);
    }

    @PostMapping
    public void saveAnimal(@RequestBody AnimalDomestico animalDomestico, Authentication authentication){
        animalDomesticoService.saveAnimal(animalDomestico, (User) authentication.getPrincipal());
        log.info("Usuario {} cadastrou novo animal", User.class);
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
        log.info("deletou animal");
    }

    @PostMapping(value = "/comFoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveAnimalComFoto(@RequestParam("animalDomestico") String animalDomestico, @RequestParam("foto")MultipartFile file, Authentication authentication) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        AnimalDomestico novoAnimal = objectMapper.readValue(animalDomestico, AnimalDomestico.class);

        String fotoAnimal = UUID.randomUUID() + "_" + Long.toHexString(new Date().getTime());
        novoAnimal.setFotoAnimal(fotoAnimal + ".jpg");
        animalDomesticoService.saveAnimal( novoAnimal, (User) authentication.getPrincipal());

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
