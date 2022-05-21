package com.tcc.sospets.business.models.dto;

import com.tcc.sospets.business.models.entities.CorAnimal;
import com.tcc.sospets.business.models.entities.Especie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDomesticoResponse {

    String genero;
    String porte;
    CorAnimal corAnimal;
    String acessorio;
    Especie especie;
    String condicaoAnimal;
    String localizacao;
    String fotoAnimal;
}
