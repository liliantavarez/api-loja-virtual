package com.dev.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 2, max = 35)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
