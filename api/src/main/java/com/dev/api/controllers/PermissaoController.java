package com.dev.api.controllers;

import com.dev.api.dto.PermissaoDTO;
import com.dev.api.entities.Permissao;
import com.dev.api.services.PermissaoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    final private PermissaoService permissaoService;

    public PermissaoController(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @GetMapping
    ResponseEntity<List<PermissaoDTO>> buscarTodos() {
        return ResponseEntity.ok(permissaoService.buscarTodos());
    }

    @PostMapping
    ResponseEntity<Permissao> inserir(@RequestBody @Valid Permissao permissao, UriComponentsBuilder uriComponentsBuilder) {
        Permissao novaPermissao = permissaoService.inserir(permissao);
        var uri = uriComponentsBuilder.path("/permissao/{id}").buildAndExpand(novaPermissao.getId()).toUri();

        return ResponseEntity.created(uri).body(novaPermissao);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Permissao> alterar(@RequestBody Permissao permissaoPessoa, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(permissaoService.alterar(permissaoPessoa, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable @Valid Long id) {
        permissaoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
