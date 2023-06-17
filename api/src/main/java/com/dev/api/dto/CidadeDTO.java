package com.dev.api.dto;

import com.dev.api.entities.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CidadeDTO {
    @NotBlank(message = "Insira o nome da cidade!")
    @NotNull
    @Size(min = 2, max = 35)
    private String nome;
    private Estado estado;
}
