package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.AnimalDomestico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAnimalDomestico extends JpaRepository<AnimalDomestico, String> {

    List<AnimalDomestico> findByNomeAnd
}
