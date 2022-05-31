package com.tcc.sospets.business.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDomesticoResponse {

    String tipoUsuario;
    String genero;
    String porte;
    String cor;
    String acessorio;
    Especie especie;
    String condicaoAnimal;
    String localizacao;
    String fotoAnimal;
}
