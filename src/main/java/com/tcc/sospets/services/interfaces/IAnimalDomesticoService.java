package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.AnimalDomestico;
import com.tcc.sospets.business.models.entities.CorAnimal;
import com.tcc.sospets.business.models.entities.Especie;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IAnimalDomesticoService {

    Page<AnimalDomestico> getAnimaisDomesticos(int page, int pageSize);

    List<AnimalDomestico> queryAnimal(String porte,
                                          Especie especie,
                                          CorAnimal corAnimal,
                                          String acessorio,
                                          String condicaoAnimal,
                                          String localizacao,
                                          String genero);


    void saveAnimal(AnimalDomestico animalDomestico);

    void atualizaAnimal(AnimalDomestico animalDomestico, String animalDomesticoId);

    AnimalDomestico pegaAnimal(String animalDomesticoId);

    void deletaAnimal(String animalDomesticoId);


}
