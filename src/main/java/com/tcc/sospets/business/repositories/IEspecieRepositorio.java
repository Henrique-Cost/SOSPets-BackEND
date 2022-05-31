package com.tcc.sospets.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecieRepositorio extends JpaRepository<Especie, String> {


}
