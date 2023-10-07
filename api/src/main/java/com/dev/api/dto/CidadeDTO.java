package com.dev.api.dto;

import com.dev.api.entities.Estado;
import lombok.Data;


@Data
public class CidadeDTO {
    private String nome;
    private Estado estado;
}
