package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.RacaCachorro;
import com.tcc.sospets.services.RacaCachorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/racaCachorro")
public class RacaCachorroController {

    @Autowired
    RacaCachorroService racaCachorroService;

    @GetMapping
    public List<RacaCachorro> getRacasCachorros(){
        return racaCachorroService.getRacasCachorros();
    }

    @GetMapping("/{id_racaCachorro}")
    public RacaCachorro pegaRacaCachorro(@PathVariable("id_racaCachorro") String id_racaCachorro){
        return racaCachorroService.pegaRacaCachorro(id_racaCachorro);
    }

    @PostMapping("/{id_racaCachorro}")
    public void saveRacaCachorro(@RequestBody RacaCachorro racaCachorro){
        racaCachorroService.saveRacaCachorro(racaCachorro);
    }

    @PutMapping("/{id_racaCachorro}")
    public void atualizaRacaCachorro(@PathVariable("id_racaCachorro") String id_racaCachorro, @RequestBody RacaCachorro racaCachorro){
        racaCachorroService.atualizaRacaCachorro(racaCachorro, id_racaCachorro);
    }

    @DeleteMapping("/{id_racaCachorro}")
    public void deletaRacaCachorro(@PathVariable("id_racaCachorro") String id_racaCachorro){
        racaCachorroService.deletaRacaCachorro(id_racaCachorro);
    }
}
