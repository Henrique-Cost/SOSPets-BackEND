package com.tcc.sospets.business.models.dto;

import com.tcc.sospets.business.models.entities.CorAnimal;
import com.tcc.sospets.business.models.entities.Especie;
import com.tcc.sospets.business.models.entities.TipoUsuarioClasse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDomesticoRequest {

    TipoUsuarioClasse tipoUsuarioClasse;
    String Genero;
    String porte;
    Especie especie;
    CorAnimal corAnimal;
    String acessorio;
    String condicaoAnimal;
    String localizacao;
    String fotoAnimal;
}
