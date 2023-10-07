package com.dev.api.repositories;

import com.dev.api.dto.MarcaDTO;
import com.dev.api.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
