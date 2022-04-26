package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.Especie;

import java.util.List;

public interface IEspecieService {

    List<Especie> getEspecies();

    Especie pegaEspecie(String especieId);

    void saveEspecie(Especie especie);

    void atualizaEspecie(Especie especie, String especieId);

    void deletaEspecie(String especieId);
}
