package com.dev.api.controllers;

import com.dev.api.dto.MarcaDTO;
import com.dev.api.entities.Marca;
import com.dev.api.services.MarcaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    private MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> buscarTodos() {
        return ResponseEntity.ok(marcaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Marca> inserir(@Valid @RequestBody Marca marca, UriComponentsBuilder uriComponentsBuilder) {
        Marca marcaCriada = marcaService.inserir(marca);
        var uri = uriComponentsBuilder.path("/marca/{id}").buildAndExpand(marcaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(marcaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Marca> alterar(@RequestBody Marca marca, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(marcaService.alterar(marca, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        marcaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
