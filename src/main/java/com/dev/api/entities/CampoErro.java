package com.dev.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CampoErro {
        private String campo;
        private String message;
}
