package com.dev.api.repositories;

import com.dev.api.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail (String email);

    Pessoa findByEmailAndAndCodigoRecuperacaoSenha(String email, String codigoRecuperacao);
}
