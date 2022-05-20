package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.AnimalDomestico;
import com.tcc.sospets.business.models.entities.CorAnimal;
import com.tcc.sospets.business.models.entities.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnimalDomesticoRepositorio extends JpaRepository<AnimalDomestico, String>{
    List<AnimalDomestico> findByPorteAndEspecieAndCorAndAcessorioAndCondicaoAnimalAndLocalizacao(
            String porte,
            Especie especie,
            CorAnimal corAnimal,
            String acessorio,
            String condicaoAnimal,
            String localizacao
    );


}

