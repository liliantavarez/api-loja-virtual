package com.dev.api.controllers;

import com.dev.api.dto.EstadoDTO;
import com.dev.api.entities.Estado;
import com.dev.api.services.EstadoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
@AllArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> buscarTodos() {
        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    @PostMapping
    ResponseEntity<EstadoDTO> inserir(@RequestBody @Valid Estado estado, UriComponentsBuilder uriComponentsBuilder) {
        EstadoDTO estadoDTO = estadoService.inserir(estado);

        var uri = uriComponentsBuilder.path("/estado/{id}").buildAndExpand(estado.getId()).toUri();

        return ResponseEntity.created(uri).body(estadoDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        estadoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<EstadoDTO> alterar(@RequestBody Estado estado, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(estadoService.alterar(estado, id));
    }

}
