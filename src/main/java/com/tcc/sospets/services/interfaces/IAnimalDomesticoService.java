package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.dto.AnimalDomesticoRequest;
import com.tcc.sospets.business.models.entities.*;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IAnimalDomesticoService {

    Page<AnimalDomestico> getAnimaisDomesticos(Integer page, Integer pageSize);

    List<AnimalDomestico> queryAnimal(PorteEnum porte,
                                          EspecieEnum especie,
                                          CorEnum cor,
                                          String acessorio,
                                          CondicaoAnimalEnum condicaoAnimal,
                                          GeneroEnum genero);


    void saveAnimal(AnimalDomestico animalDomestico, User user);

    void atualizaAnimal(AnimalDomestico animalDomestico, String animalDomesticoId);

    AnimalDomestico pegaAnimal(String animalDomesticoId);

    void deletaAnimal(String animalDomesticoId);


}
