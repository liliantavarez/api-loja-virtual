package com.dev.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Insira seu nome!")
    private String nome;
    @NotBlank(message = "Insira seu CPF!")
    @Size(min = 11, max = 14)
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotBlank(message = "Insira seu e-mail!")
    @Size(min = 6, max = 120)
    @Email(message = "E-mail inválido")
    private String email;
    @NotBlank(message = "Insira uma senha!")
    @Size(min = 8)
    private String senha;
    @NotBlank(message = "Insira seu endereço!")
    @Size(min = 5)
    private String endereco;
    @NotBlank(message = "Insira seu cep!")
    @Size(min = 8, max = 9, message = "CEP inválido")
    private String cep;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE) //Desabilita o setter fornecido pelo lombok
    private List<PermissaoPessoa> permissoesPessoa;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public void setPermissoesPessoa(List<PermissaoPessoa> permissoesPessoa) {
        for (PermissaoPessoa permissaoPessoa : permissoesPessoa) {
            permissaoPessoa.setPessoa(this);
        }
        this.permissoesPessoa = permissoesPessoa;
    }
}
