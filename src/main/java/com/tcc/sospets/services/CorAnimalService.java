package com.tcc.sospets.services;

import com.tcc.sospets.business.models.CorAnimal;
import com.tcc.sospets.business.repositories.ICorAnimalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorAnimalService implements ICorAnimalService{

    @Autowired
    ICorAnimalRepositorio corAnimalRepositorio;

    @Override
    public List<CorAnimal> getCores() {
        return corAnimalRepositorio.findAll();
    }

    @Override
    public CorAnimal pegaCorAnimal(String id_cor) {
        CorAnimal corAnimal = corAnimalRepositorio.findById(id_cor).orElse(null);
        return corAnimal;
    }

    @Override
    public void saveCorAnimal(CorAnimal corAnimal) {
        corAnimalRepositorio.save(corAnimal);
    }

    @Override
    public void atualizaCorAnimal(CorAnimal corAnimal, String id_cor) {
        CorAnimal corAnterior = corAnimalRepositorio.findById(id_cor).orElse(null);
        corAnterior.setCor(corAnimal.getCor());
        corAnterior.setOutros(corAnimal.getOutros());
        corAnimalRepositorio.save(corAnterior);
    }

    @Override
    public void deletaCorAnimal(String id_cor) {
        corAnimalRepositorio.deleteById(id_cor);
    }
}
