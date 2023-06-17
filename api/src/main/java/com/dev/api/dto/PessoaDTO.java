package com.dev.api.dto;

import com.dev.api.entities.Cidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class PessoaDTO {

    @NotBlank
    private String nome;
    @NotBlank
    @Size(min = 11, max = 14)
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotBlank
    @Size(min = 6, max = 120)
    @Email(message = "E-mail inválido")
    private String email;
    @NotBlank
    @Size(min = 8)
    private String senha;
    @NotBlank
    @Size(min = 5)
    private String endereco;
    @NotBlank
    @Size(min = 8, max = 9, message = "CEP inválido")
    private String cep;
    private Cidade cidade;
}
