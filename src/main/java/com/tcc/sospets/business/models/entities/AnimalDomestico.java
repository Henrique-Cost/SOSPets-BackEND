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
    @GeneratedValue(generator = "uuid", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    private String animalDomesticoId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    private EspecieEnum especie;
    private CondicaoAnimalEnum condicaoAnimal;
    private CorEnum cor;
    private GeneroEnum genero;
    private PorteEnum porte;
    private TipoUsuarioEnum tipoUsuario;
    private String acessorio;
    private String localizacao;
    private String fotoAnimal;
}
