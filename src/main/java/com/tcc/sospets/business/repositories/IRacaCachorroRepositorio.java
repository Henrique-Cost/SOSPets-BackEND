package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.Especie;
import com.tcc.sospets.business.models.RacaCachorro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRacaCachorroRepositorio extends JpaRepository<RacaCachorro, String> {

    List<RacaCachorro> findByEspecie(Especie especie);
}