package com.dev.api.controllers;

import com.dev.api.entities.Categoria;
import com.dev.api.services.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria, UriComponentsBuilder uriComponentsBuilder) {
        Categoria categoriaCriada = categoriaService.inserir(categoria);
        var uri = uriComponentsBuilder.path("categoria/{id}").buildAndExpand(categoriaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(categoriaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(categoriaService.alterar(categoria, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
