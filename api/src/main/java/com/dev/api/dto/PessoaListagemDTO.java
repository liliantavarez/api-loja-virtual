package com.dev.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class PessoaListagemDTO {

    @NotBlank
    private String nome;
    @NotBlank
    @Size(min = 6, max = 120)
    @Email(message = "E-mail inválido")
    private String email;
    @NotBlank
    @Size(min = 5)
    private String endereco;
    @NotBlank
    @Size(min = 8, max = 9, message = "CEP inválido")
    private String cep;
    private CidadeListagemDTO cidade;
}
