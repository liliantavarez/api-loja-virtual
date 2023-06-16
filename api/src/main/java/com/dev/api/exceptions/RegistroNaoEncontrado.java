package com.dev.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistroNaoEncontrado extends RuntimeException {
    public RegistroNaoEncontrado(Long id) {
        super("Registro não encontrado com id: " + id);
    }
}
