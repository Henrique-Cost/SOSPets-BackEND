package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.CorAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICorAnimalRepositorio extends JpaRepository<CorAnimal, String> {

    List<CorAnimal> findByCor(CorAnimal corAnimal);
}
