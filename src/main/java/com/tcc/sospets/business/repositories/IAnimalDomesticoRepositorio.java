package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.AnimalDomestico;

import com.tcc.sospets.business.models.entities.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAnimalDomesticoRepositorio extends JpaRepository<AnimalDomestico, String>{
    List<AnimalDomestico> findByPorteAndEspecieAndCorAndAcessorioAndCondicaoAnimalAndLocalizacaoAndGenero(
            String porte,
            Especie especie,
            String cor,
            String acessorio,
            String condicaoAnimal,
            String localizacao,
            String genero
    );


}

