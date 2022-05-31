package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.*;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IAnimalDomesticoService {

    Page<AnimalDomestico> getAnimaisDomesticos(Integer page, Integer pageSize);

    List<AnimalDomestico> queryAnimal(PorteEnum porte,
                                          EspecieEnum especie,
                                          CorEnum cor,
                                          String acessorio,
                                          CondicaoAnimalEnum condicaoAnimal,
                                          String localizacao,
                                          GeneroEnum genero);


    void saveAnimal(AnimalDomestico animalDomestico);

    void atualizaAnimal(AnimalDomestico animalDomestico, String animalDomesticoId);

    AnimalDomestico pegaAnimal(String animalDomesticoId);

    void deletaAnimal(String animalDomesticoId);


}
