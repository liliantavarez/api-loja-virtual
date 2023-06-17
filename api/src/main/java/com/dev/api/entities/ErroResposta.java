package com.dev.api.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErroResposta {
    private List<CampoErro> errors;

    public ErroResposta() {
        errors = new ArrayList<>();
    }

    public void addError(String campo, String mensagem) {
        CampoErro error = new CampoErro(campo, mensagem);
        errors.add(error);
    }
}


