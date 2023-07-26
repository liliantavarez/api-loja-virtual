package com.dev.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Insira o nome da categoria!")
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public void atualizarNome(String nome) {
        this.nome = nome;
    }

    public void setDataCriacao() {
        this.dataCriacao = new Date();
    }

    public void setDataAtualizacao() {
        this.dataAtualizacao = new Date();
    }
}
