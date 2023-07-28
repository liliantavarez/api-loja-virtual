package com.dev.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "permissao_pessoa")
public class PermissaoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Insira ID da pessoa")
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    @ManyToOne
    private Pessoa pessoa;
    @NotNull(message = "Insira ID da permissão")
    @JoinColumn(name = "permissao_id")
    @ManyToOne
    private Permissao permissao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
