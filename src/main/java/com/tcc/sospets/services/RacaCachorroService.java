package com.tcc.sospets.services;

import com.tcc.sospets.business.models.RacaCachorro;
import com.tcc.sospets.business.repositories.IRacaCachorroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacaCachorroService implements IRacaCachorroService{

    @Autowired
    IRacaCachorroRepositorio racaCachorroRepositorio;

    @Override
    public List<RacaCachorro> getRacasCachorros() {
        return racaCachorroRepositorio.findAll();
    }

    @Override
    public RacaCachorro pegaRacaCachorro(String id_racaCachorro) {
        RacaCachorro racaCachorro = racaCachorroRepositorio.findById(id_racaCachorro).orElse(null);
        return racaCachorro;
    }

    @Override
    public void saveRacaCachorro(RacaCachorro racaCachorro) {
        racaCachorroRepositorio.save(racaCachorro);
    }

    @Override
    public void atualizaRacaCachorro(RacaCachorro racaCachorro, String id_racaCachorro) {
        RacaCachorro racaCachorroAnterior = racaCachorroRepositorio.findById(id_racaCachorro).orElse(null);
        racaCachorroAnterior.setRaca(racaCachorro.getRaca());
        racaCachorroAnterior.setFotoUrl(racaCachorro.getFotoUrl());
        racaCachorroRepositorio.save(racaCachorroAnterior);
    }

    @Override
    public void deletaRacaCachorro(String id_racaCachorro) {
        racaCachorroRepositorio.deleteById(id_racaCachorro);
    }
}
