package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Especie;
import com.tcc.sospets.business.repositories.IEspecieRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EspecieService implements IEspecieService {

    @Autowired
    IEspecieRepositorio especieRepositorio;


    @Override
    public List<Especie> getEspecies() {
        return especieRepositorio.findAll();
    }

    @Override
    public Especie pegaEspecie(String id_especie) {
        Especie especie = especieRepositorio.findById(id_especie).orElse(null);
        return especie;
    }

    @Override
    public void saveEspecie(Especie especie) {
        especieRepositorio.save(especie);
    }

    @Override
    public void atualizaEspecie(Especie especie, String id_especie) {
        Especie especieAnterior = especieRepositorio.findById(id_especie).orElse(null);
        especieAnterior.setEspecie(especie.getEspecie());
        especieRepositorio.save(especieAnterior);
    }

    @Override
    public void deletaEspecie(String id_especie) {
        especieRepositorio.deleteById(id_especie);
    }
}
