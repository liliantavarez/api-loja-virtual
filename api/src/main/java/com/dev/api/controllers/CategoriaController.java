package com.dev.api.controllers;

import com.dev.api.dto.CategoriaDTO;
import com.dev.api.entities.Categoria;
import com.dev.api.services.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> inserir(@Valid @RequestBody Categoria categoria, UriComponentsBuilder uriComponentsBuilder) {
        var uri = uriComponentsBuilder.path("categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoriaService.inserir(categoria));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoriaDTO> alterar(@Valid @RequestBody Categoria categoria, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(categoriaService.alterar(categoria, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
