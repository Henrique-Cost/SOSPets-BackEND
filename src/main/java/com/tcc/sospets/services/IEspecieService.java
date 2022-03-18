package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Especie;

import java.util.List;

public interface IEspecieService {

    List<Especie> getEspecies();

    Especie pegaEspecie(String id_especie);

    void saveEspecie(Especie especie);

    void atualizaEspecie(Especie especie, String id_especie);

    void deletaEspecie(String id_especie);
}
