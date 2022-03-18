package com.tcc.sospets.services;

import com.tcc.sospets.business.models.RacaCachorro;

import java.util.List;

public interface IRacaCachorroService {

    List<RacaCachorro> getRacasCachorro();

    RacaCachorro pegaRacaCachorro(String id_racaCachorro);

    void saveRacaCachorro(RacaCachorro racaCachorro);

    void atualizaRacaCachorro(RacaCachorro racaCachorro, String id_racaCachorro);

    void deletaRacaCachorro(String id_racaCachorro);
}
