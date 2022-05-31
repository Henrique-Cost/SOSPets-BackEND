package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.AnimalDomestico;

import com.tcc.sospets.business.models.entities.EspecieEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnimalDomesticoRepositorio extends JpaRepository<AnimalDomestico, String>{
    List<AnimalDomestico> findByPorteAndEspecieAndCorAndAcessorioAndCondicaoAnimalAndLocalizacaoAndGenero(
            String porte, //enum
            EspecieEnum especie,
            String cor, //Enum
            String acessorio,
            String condicaoAnimal, //Enum
            String localizacao,
            String genero // Boolean
    );


}

