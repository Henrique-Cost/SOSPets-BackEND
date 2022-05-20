package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.AnimalDomestico;
import com.tcc.sospets.business.repositories.IAnimalDomesticoRepositorio;
import com.tcc.sospets.services.interfaces.IAnimalDomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalDomesticoService implements IAnimalDomesticoService {

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
    public void atualizaAnimal(AnimalDomestico animalDomestico, String animalDomesticoId) {
        AnimalDomestico animalAnterior = animalDomesticoRepositorio.findById(animalDomesticoId).orElse(null);
        animalAnterior.setPorte(animalDomestico.getPorte());
        animalAnterior.setGenero(animalDomestico.getGenero());
        animalAnterior.setAcessorio(animalDomestico.getAcessorio());
        animalAnterior.setCondicaoAnimal(animalDomestico.getCondicaoAnimal());
        animalAnterior.setLocalizacao(animalDomestico.getLocalizacao());
        animalAnterior.setTipoUsuarioClasse(animalDomestico.getTipoUsuarioClasse());
        animalAnterior.setFotoAnimal(animalDomestico.getFotoAnimal());
        animalAnterior.setCorAnimal(animalDomestico.getCorAnimal());
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