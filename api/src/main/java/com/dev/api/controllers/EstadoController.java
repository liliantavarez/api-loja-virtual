package com.dev.api.controllers;

import com.dev.api.dto.EstadoDTO;
import com.dev.api.entities.Estado;
import com.dev.api.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> buscarTodos() {
        return estadoService.buscarTodos();
    }

    @PostMapping
    ResponseEntity<Estado> inserir(@RequestBody @Validated EstadoDTO estadoDTO, UriComponentsBuilder uriComponentsBuilder) {
        return estadoService.inserir(estadoDTO, uriComponentsBuilder);
    }

    @DeleteMapping("/{id}")
    ResponseEntity excluir(@PathVariable Long id) {
        return estadoService.excluir(id);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Estado> alterar(@RequestBody EstadoDTO estadoDTO, @PathVariable Long id) {
        return estadoService.alterar(estadoDTO, id);
    }

}
