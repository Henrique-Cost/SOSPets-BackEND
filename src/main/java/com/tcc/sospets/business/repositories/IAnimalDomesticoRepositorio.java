package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAnimalDomesticoRepositorio extends JpaRepository<AnimalDomestico, String>{
    @Query("SELECT u FROM AnimalDomestico u WHERE u.porte = :porte" +
            " AND u.especie = :especie" +
            " AND u.cor = :cor" +
            " AND u.acessorio LIKE :acessorio" +
            " AND u.condicaoAnimal = :condicaoAnimal" +
            " AND u.genero = :genero")
    List<AnimalDomestico> buscaAnimal(
            PorteEnum porte,
            EspecieEnum especie,
            CorEnum cor,
            String acessorio,
            CondicaoAnimalEnum condicaoAnimal,
            GeneroEnum genero);


}





