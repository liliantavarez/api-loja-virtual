package com.dev.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
