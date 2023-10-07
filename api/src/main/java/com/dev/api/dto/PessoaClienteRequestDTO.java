package com.dev.api.dto;

import com.dev.api.entities.Cidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class PessoaClienteRequestDTO {
    @NotBlank(message = "Insira seu nome!")
    private String nome;
    @NotBlank(message = "Insira seu CPF!")
    @CPF(message = "CPF inválido")
    @Size(min = 11, max = 14)
    private String cpf;
    @NotBlank(message = "Insira seu e-mail!")
    @Size(min = 6, max = 120)
    @Email(message = "E-mail inválido")
    private String email;
    @NotBlank(message = "Insira seu endereço!")
    @Size(min = 5)
    private String endereco;
    @NotBlank(message = "Insira seu cep!")
    @Size(min = 8, max = 9, message = "CEP inválido")
    private String cep;
    private Cidade cidade;
}
