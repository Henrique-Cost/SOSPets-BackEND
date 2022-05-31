package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnimalDomesticoRepositorio extends JpaRepository<AnimalDomestico, String>{
    List<AnimalDomestico> findByPorteAndEspecieAndCorAndAcessorioAndCondicaoAnimalAndLocalizacaoAndGenero(
            PorteEnum porte, //enum
            EspecieEnum especie,
            CorEnum cor, //Enum
            String acessorio,
            CondicaoAnimalEnum condicaoAnimal, //Enum
            String localizacao,
            GeneroEnum genero // Boolean
    );


}

