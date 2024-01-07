package com.dev.api.dto;

import com.dev.api.entities.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class PessoaDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String codigoRecuperacaoSenha;
    private String endereco;
    private String cep;
    private Cidade cidade;
}
