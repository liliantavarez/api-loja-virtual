package com.dev.api.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class MarcaDTO {
    private String nome;
}
