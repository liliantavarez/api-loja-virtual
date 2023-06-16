package com.dev.api.controllers;

import com.dev.api.dto.EstadoDTO;
import com.dev.api.entities.Estado;
import com.dev.api.services.EstadoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    @PostMapping
    ResponseEntity<Estado> inserir(@RequestBody @Valid EstadoDTO estadoDTO, UriComponentsBuilder uriComponentsBuilder) {
        Estado estado = estadoService.inserir(estadoDTO);

        var uri = uriComponentsBuilder.path("/estado/{id}").buildAndExpand(estado.getId()).toUri();

        return ResponseEntity.created(uri).body(estado);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        estadoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Estado> alterar(@RequestBody EstadoDTO estadoDTO, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(estadoService.alterar(estadoDTO, id));
    }

}
