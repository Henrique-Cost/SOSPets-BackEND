package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.*;

import com.tcc.sospets.business.repositories.IAnimalDomesticoRepositorio;
import com.tcc.sospets.services.interfaces.IAnimalDomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalDomesticoService implements IAnimalDomesticoService {

    @Autowired
    IAnimalDomesticoRepositorio animalDomesticoRepositorio;


    @Override
    public Page<AnimalDomestico> getAnimaisDomesticos(Integer page, Integer pageSize) {
        Page<AnimalDomestico> animais = animalDomesticoRepositorio.findAll(PageRequest.of(page, pageSize));
        return animais;
    }

    @Override
    public List<AnimalDomestico> buscaAnimal(
            PorteEnum porte,
            EspecieEnum especie,
            CorEnum cor,
            String acessorio,
            CondicaoAnimalEnum condicaoAnimal,
            GeneroEnum genero
    )
    {
        List<AnimalDomestico> queryAnimais =
                animalDomesticoRepositorio.findByPorteAndEspecieAndCorAndAcessorioAndCondicaoAnimalAndGenero(
                        porte.name(),
                        especie.name(),
                        cor.name(),
                        acessorio,
                        condicaoAnimal.name(),
                        genero.name()
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
        animalAnterior.setAcessorio(animalDomestico.getAcessorio());
        animalAnterior.setCondicaoAnimal(animalDomestico.getCondicaoAnimal());
        animalAnterior.setCor(animalDomestico.getCor());
        animalAnterior.setGenero(animalDomestico.getGenero());
        animalAnterior.setPorte(animalDomestico.getPorte());
        animalAnterior.setEspecie(animalDomestico.getEspecie());
        animalAnterior.setTipoUsuario(animalDomestico.getTipoUsuario());
        animalAnterior.setLocalizacao(animalDomestico.getLocalizacao());
        animalAnterior.setFotoAnimal(animalDomestico.getFotoAnimal());
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