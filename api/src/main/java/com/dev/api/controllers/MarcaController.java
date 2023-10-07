package com.dev.api.controllers;

import com.dev.api.dto.MarcaDTO;
import com.dev.api.entities.Marca;
import com.dev.api.services.MarcaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@AllArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> buscarTodos() {
        return ResponseEntity.ok(marcaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<MarcaDTO> inserir(@Valid @RequestBody Marca marca, UriComponentsBuilder uriComponentsBuilder) {
        MarcaDTO marcaCriada = marcaService.inserir(marca);
        var uri = uriComponentsBuilder.path("/marca/{id}").buildAndExpand(marca.getId()).toUri();
        return ResponseEntity.created(uri).body(marcaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MarcaDTO> alterar(@RequestBody Marca marca, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(marcaService.alterar(marca, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        marcaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
