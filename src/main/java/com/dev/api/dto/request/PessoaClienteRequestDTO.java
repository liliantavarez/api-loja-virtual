package com.dev.api.dto.request;

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
    @CPF(message = "CPF inválido")
    @Size(min = 11, max = 14)
    private String cpf;
    @Email(message = "E-mail inválido")
    @Size(min = 6, max = 120)
    private String email;
    private String endereco;
    @Size(min = 8, max = 9, message = "CEP inválido")
    private String cep;
    private Cidade cidade;
}
