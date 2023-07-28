package com.dev.api.dto;

import lombok.Data;

@Data
public class PessoaListagemDTO {

    private String nome;
    private String email;
    private String endereco;
    private String cep;
    private CidadeListagemDTO cidade;
}
