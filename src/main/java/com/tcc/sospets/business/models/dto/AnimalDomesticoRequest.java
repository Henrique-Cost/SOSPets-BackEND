package com.tcc.sospets.business.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDomesticoRequest {

    String tipoUsuario;
    String Genero;
    String porte;
    Especie especie;
    String cor;
    String acessorio;
    String condicaoAnimal;
    String localizacao;
    String fotoAnimal;
}
