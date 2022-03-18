package com.tcc.sospets.services;

import com.tcc.sospets.business.models.AnimalDomestico;

import java.util.List;

public interface IAnimalDomesticoService {

    List<AnimalDomestico> getAnimaisDomesticos();

    void saveAnimal(AnimalDomestico animalDomestico);

    void atualizaAnimal(AnimalDomestico animalDomestico, String id_animalDomestico);

    AnimalDomestico pegaAnimal(String id_animalDomestico);

    void deletaAnimal(String id_animalDomestico);


}
