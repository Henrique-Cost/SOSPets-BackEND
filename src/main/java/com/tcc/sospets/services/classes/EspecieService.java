package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.Especie;
import com.tcc.sospets.business.repositories.IEspecieRepositorio;
import com.tcc.sospets.services.interfaces.IEspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService implements IEspecieService {

    @Autowired
    IEspecieRepositorio especieRepositorio;


    @Override
    public List<Especie> getEspecies() {
        return especieRepositorio.findAll();
    }

    @Override
    public Especie pegaEspecie(String especieId) {
        Especie especie = especieRepositorio.findById(especieId).orElse(null);
        return especie;
    }

    @Override
    public void saveEspecie(Especie especie) {
        especieRepositorio.save(especie);
    }

    @Override
    public void atualizaEspecie(Especie especie, String especieId) {
        Especie especieAnterior = especieRepositorio.findById(especieId).orElse(null);
        especieAnterior.setEspecies(especie.getEspecies());
        especieAnterior.setOutros(especie.getOutros());
        especieAnterior.setRacaCachorro(especie.getRacaCachorro());
        especieRepositorio.save(especieAnterior);
    }

    @Override
    public void deletaEspecie(String especieId) {
        especieRepositorio.deleteById(especieId);
    }
}