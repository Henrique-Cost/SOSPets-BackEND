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
@Table(name = "animal_domestico")
public class AnimalDomestico {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    private String id_animalDomestico;


    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    private String id_usuario;

    @JoinColumn(name = "uacas_Cachorro", referencedColumnName = "id_racaCachorro")
    private String id_racaCachorro;

    @JoinColumn(name = "especie", referencedColumnName = "id_especie")
    private String id_especie;

    @JoinColumn(name = "cores", referencedColumnName = "id_cor")
    private String id_cor;

    @JoinColumn(name = "tipo_usuario", referencedColumnName = "id_tipo_usuario")
    private String id_tipo_usuario;

    private Float peso;
    private String Genero;
    private String acessorio;
    private String condicaoAnimal;
    private String localizacao;
    private String fotoAnimal;
}
