package com.tcc.sospets.services;

import com.tcc.sospets.business.models.CorAnimal;

import java.util.List;

public interface ICorAnimalService {

    List<CorAnimal> getCores();

    CorAnimal pegaCorAnimal(String id_cor);

    void saveCorAnimal(CorAnimal corAnimal);

    void atualizaCorAnimal(CorAnimal corAnimal, String id_cor);

    void deletaCorAnimal(String id_cor);
}
