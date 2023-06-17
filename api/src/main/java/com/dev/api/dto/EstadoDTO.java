package com.dev.api.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class EstadoDTO {
    @NotBlank(message = "Insira o nome do estado!")
    @Nonnull
    @Length(min = 4, max = 25)
    private String nome;
    @NotBlank(message = "Insira a sigla do estado!")
    @Nonnull
    @Length(min = 2, max = 2)
    private String sigla;
}
