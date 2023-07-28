package com.dev.api.repositories;

import com.dev.api.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
}
