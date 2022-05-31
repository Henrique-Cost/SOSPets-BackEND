package com.tcc.sospets.business.models.dto;

import com.tcc.sospets.business.models.entities.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDomesticoResponse {

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
