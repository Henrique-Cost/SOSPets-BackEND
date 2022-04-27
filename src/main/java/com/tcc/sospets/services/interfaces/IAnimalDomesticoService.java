package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.AnimalDomestico;

import java.util.List;

public interface IAnimalDomesticoService {

    List<AnimalDomestico> getAnimaisDomesticos();

    void saveAnimal(AnimalDomestico animalDomestico);

    void atualizaAnimal(AnimalDomestico animalDomestico, String animalDomesticoId);

    AnimalDomestico pegaAnimal(String animalDomesticoId);

    void deletaAnimal(String animalDomesticoId);


}
