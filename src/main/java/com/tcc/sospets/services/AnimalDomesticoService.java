package com.tcc.sospets.services;

import com.tcc.sospets.business.models.AnimalDomestico;
import com.tcc.sospets.business.repositories.IAnimalDomesticoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalDomesticoService implements IAnimalDomesticoService{

    @Autowired
    IAnimalDomesticoRepositorio animalDomesticoRepositorio;

    @Override
    public List<AnimalDomestico> getAnimaisDomesticos() {
        return animalDomesticoRepositorio.findAll();
    }

    @Override
    public void saveAnimal(AnimalDomestico animalDomestico) {
        animalDomesticoRepositorio.save(animalDomestico);
    }

    @Override
    public void atualizaAnimal(AnimalDomestico animalDomestico, String id_animalDomestico) {
        AnimalDomestico animalAnterior = animalDomesticoRepositorio.findById(id_animalDomestico).orElse(null);
        animalAnterior.setPeso(animalDomestico.getPeso());
        animalAnterior.setGenero(animalDomestico.getGenero());
        animalAnterior.setAcessorio(animalDomestico.getAcessorio());
        animalAnterior.setCondicaoAnimal(animalDomestico.getCondicaoAnimal());
        animalAnterior.setLocalizacao(animalDomestico.getLocalizacao());
        animalAnterior.setFotoAnimal(animalDomestico.getFotoAnimal());
        animalDomesticoRepositorio.save(animalAnterior);
    }

    @Override
    public AnimalDomestico pegaAnimal(String id_animalDomestico) {
        AnimalDomestico animalDomestico = animalDomesticoRepositorio.findById(id_animalDomestico).orElse(null);
        return animalDomestico;
    }

    @Override
    public void deletaAnimal(String id_animalDomestico) {
        animalDomesticoRepositorio.deleteById(id_animalDomestico);
    }
}
