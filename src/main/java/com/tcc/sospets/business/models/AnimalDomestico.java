package com.tcc.sospets.business.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.repository.cdi.Eager;

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
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "especieId", nullable = false)
    private Especie especie;

    @Embedded
    private CorAnimal corAnimal;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoUsuarioId", nullable = false)
    private TipoUsuarioClasse tipoUsuarioClasse;

    private Float peso;
    private String Genero;
    private String acessorio;
    private String condicaoAnimal;
    private String localizacao;
    private String fotoAnimal;
}
