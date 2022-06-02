package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnimalDomesticoRepositorio extends JpaRepository<AnimalDomestico, String>{
    @Modifying
    @Query(value = "SELECT u FROM AnimalDomestico u WHERE u.porte = '%porte%'" +
            " AND u.especie = '%especie%'" +
            " AND u.cor = '%cor%'" +
            " AND u.acessorio LIKE '%acessorio%'" +
            " AND u.condicaoAnimal = '%condicaoAnimal%'" +
            " And u.genero = '%genero%'")
    List<AnimalDomestico> findByPorteAndEspecieAndCorAndAcessorioAndCondicaoAnimalAndGenero(
            String porte,
            String especie,
            String cor,
            String acessorio,
            String condicaoAnimal,
            String genero);


}

