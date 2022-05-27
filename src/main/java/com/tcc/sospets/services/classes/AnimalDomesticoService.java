package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.AnimalDomestico;

import com.tcc.sospets.business.models.entities.Especie;
import com.tcc.sospets.business.repositories.IAnimalDomesticoRepositorio;
import com.tcc.sospets.services.interfaces.IAnimalDomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalDomesticoService implements IAnimalDomesticoService {

    @Autowired
    IAnimalDomesticoRepositorio animalDomesticoRepositorio;


    @Override
    public Page<AnimalDomestico> getAnimaisDomesticos(int page, int pageSize) {
        Page<AnimalDomestico> animais = animalDomesticoRepositorio.findAll(PageRequest.of(page, pageSize));
        return animais;
    }

    @Override
    public List<AnimalDomestico> queryAnimal(
            String porte,
            Especie especie,
            String cor,
            String acessorio,
            String condicaoAnimal,
            String localizacao,
            String genero
    ) {
        List<AnimalDomestico> queryAnimais =
                animalDomesticoRepositorio.findByPorteAndEspecieAndCorAndAcessorioAndCondicaoAnimalAndLocalizacaoAndGenero(
                        porte,
                        especie,
                        cor,
                        acessorio,
                        condicaoAnimal,
                        localizacao,
                        genero
                );
        return queryAnimais;
    }


    @Override
    public void saveAnimal(AnimalDomestico animalDomestico) {
        animalDomesticoRepositorio.save(animalDomestico);
    }

    @Override
    public void atualizaAnimal(AnimalDomestico animalDomestico, String animalDomesticoId) {
        AnimalDomestico animalAnterior = animalDomesticoRepositorio.findById(animalDomesticoId).orElse(null);
        animalAnterior.setPorte(animalDomestico.getPorte());
        animalAnterior.setGenero(animalDomestico.getGenero());
        animalAnterior.setAcessorio(animalDomestico.getAcessorio());
        animalAnterior.setCondicaoAnimal(animalDomestico.getCondicaoAnimal());
        animalAnterior.setLocalizacao(animalDomestico.getLocalizacao());
        animalAnterior.setFotoAnimal(animalDomestico.getFotoAnimal());
        animalAnterior.setCor(animalDomestico.getCor());
        animalDomesticoRepositorio.save(animalAnterior);
    }

    @Override
    public AnimalDomestico pegaAnimal(String animalDomesticoId) {
        AnimalDomestico animalDomestico = animalDomesticoRepositorio.findById(animalDomesticoId).orElse(null);
        return animalDomestico;
    }

    @Override
    public void deletaAnimal(String animalDomesticoId) {
        animalDomesticoRepositorio.deleteById(animalDomesticoId);
    }
}