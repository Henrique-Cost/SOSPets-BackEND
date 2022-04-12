package com.tcc.sospets.business.repositories;

import com.tcc.sospets.business.models.Especie;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IEspecieRepositorio extends JpaRepository<Especie, String> {


}
