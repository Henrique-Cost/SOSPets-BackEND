package com.tcc.sospets.business.models.entities;

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
    private String animalDomesticoId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId", nullable = true)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "especieId", nullable = true)
    private Especie especie;


    private String tipoUsuario;
    private String cor;
    private String porte;
    private String genero;
    private String acessorio;
    private String condicaoAnimal;
    private String localizacao;
    private String fotoAnimal;
}
