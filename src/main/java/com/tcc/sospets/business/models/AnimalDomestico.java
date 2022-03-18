package com.tcc.sospets.business.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "Animal_Domestico")
public class AnimalDomestico {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    private String id_animalDomestico;

    private Usuario usuario;

    private Float peso;
    private String Genero;
    private String acessorio;
    private String condicaoAnimal;
    private String localizacao;
    private String tipoUsuario;
    private String cor;
    private String fotoAnimal;
}
