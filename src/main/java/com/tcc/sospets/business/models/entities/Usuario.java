package com.tcc.sospets.business.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import MyFirebaseServiceImpl;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    private String usuarioId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoUsuarioId")
    private TipoUsuarioClasse tipoUsuarioClasse;

    @Embedded
    private Contato contato;

    private String nomeCompleto;
    private String email;
    private String telefone;
    private String senha;
    private String tipo;
}
