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
    @Modifying
    @Query("SELECT u FROM AnimalDomestico u WHERE u.porte = (porte)")
    List<AnimalDomestico> buscaAnimal(
            String porte,
            String especie,
            String cor,
            String acessorio,
            String condicaoAnimal,
            String genero);


}



//+
//" AND bd_sospets.animal_domestico.especie = '%especie%'" +
//        " AND bd_sospets.animal_domestico.cor = '%cor%'" +
//        " AND bd_sospets.animal_domestico.acessorio LIKE '%acessorio%'" +
//        " AND bd_sospets.animal_domestico.condicao_animal = '%condicaoAnimal%'" +
//        " AND bd_sospets.animal_domestico.genero = '%genero%'"

