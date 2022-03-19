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


    @JoinColumn(name = "Usuario", referencedColumnName = "id_usuario")
    private String id_usuario;

    @JoinColumn(name = "Racas_Cachorro", referencedColumnName = "id_racaCachorro")
    private String id_racaCachorro;

    @JoinColumn(name = "Especies", referencedColumnName = "id_especie")
    private String id_especie;

    private Float peso;
    private String Genero;
    private String acessorio;
    private String condicaoAnimal;
    private String localizacao;
    private String fotoAnimal;
}
