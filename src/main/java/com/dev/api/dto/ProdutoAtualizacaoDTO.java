package com.dev.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoAtualizacaoDTO {
    private String nome;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private BigDecimal valorCusto;
    private BigDecimal valorVenda;
}
