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
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "especieId", nullable = false)
    private Especie especie;


    @JoinColumn(name = "racas_Cachorro", referencedColumnName = "id_racaCachorro")
    private String id_racaCachorro;

    @Embedded
    private CorAnimal corAnimal;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoUsuarioId", nullable = false)
    private TipoUsuarioClasse tipoUsuarioClasse;

    private Float peso;
    private String Genero;
    private String acessorio;
    private String condicaoAnimal;
    private String localizacao;
    private String fotoAnimal;
}
