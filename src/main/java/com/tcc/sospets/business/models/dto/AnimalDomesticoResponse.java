package com.tcc.sospets.business.models.dto;

import com.tcc.sospets.business.models.entities.CorAnimal;
import com.tcc.sospets.business.models.entities.Especie;
import com.tcc.sospets.business.models.entities.TipoUsuarioClasse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDomesticoResponse {

    TipoUsuarioClasse tipoUsuarioClasse;
    String genero;
    String porte;
    CorAnimal corAnimal;
    String acessorio;
    Especie especie;
    String condicaoAnimal;
    String localizacao;
    String fotoAnimal;
}
