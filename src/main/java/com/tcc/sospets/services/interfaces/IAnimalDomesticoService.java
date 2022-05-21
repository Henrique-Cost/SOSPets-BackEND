package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.AnimalDomestico;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAnimalDomesticoService {

    Page<AnimalDomestico> getAnimaisDomesticos(int page, int pageSize);

    void saveAnimal(AnimalDomestico animalDomestico);

    void atualizaAnimal(AnimalDomestico animalDomestico, String animalDomesticoId);

    AnimalDomestico pegaAnimal(String animalDomesticoId);

    void deletaAnimal(String animalDomesticoId);


}
