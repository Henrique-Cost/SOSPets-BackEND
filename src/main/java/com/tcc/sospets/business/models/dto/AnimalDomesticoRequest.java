package com.tcc.sospets.business.models.dto;

import com.tcc.sospets.business.models.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDomesticoRequest {

    PorteEnum porte;
    EspecieEnum especie;
    CorEnum cor;
    TipoUsuarioEnum tipoUsuario;
    CondicaoAnimalEnum condicaoAnimal;
    GeneroEnum genero;
    String acessorio;
    String localizacao;
    String fotoAnimal;
}
