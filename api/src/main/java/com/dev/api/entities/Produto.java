package com.dev.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Insira o nome do produto!")
    private String nome;
    @NotBlank(message = "Insira a descrição curta do produto!")
    @Column(name = "descricao_curta")
    private String descricaoCurta;
    @Column(columnDefinition = "TEXT", name = "descricao_detalhada")
    @NotBlank(message = "Insira uma descrição detalhada do produto!")
    private String descricaoDetalhada;
    @Positive
    private BigDecimal valorCusto;
    @Positive
    private BigDecimal valorVenda;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "imagems_id")
    private ProdutoImagens produtoImagens;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
