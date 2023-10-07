package com.dev.api.dto;

import com.dev.api.entities.Cidade;
import lombok.Data;

@Data
public class PessoaDTO {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String endereco;
    private String cep;
    private Cidade cidade;
}
