package com.dev.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "produto_imagens")
public class ProdutoImagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
