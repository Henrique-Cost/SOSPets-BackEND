package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.entities.AnimalDomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalDomesticoRepositorio extends JpaRepository<AnimalDomestico, String>{
}
