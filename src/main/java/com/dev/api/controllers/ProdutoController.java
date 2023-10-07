package com.dev.api.controllers;

import com.dev.api.dto.ProdutoAtualizacaoDTO;
import com.dev.api.dto.ProdutoListagemDTO;
import com.dev.api.entities.Produto;
import com.dev.api.services.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoListagemDTO>> buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<ProdutoListagemDTO> inserir(@RequestBody @Valid Produto produto, UriComponentsBuilder uriComponentsBuilder) {
        ProdutoListagemDTO produtoCriado = produtoService.inserir(produto);
        var uri = uriComponentsBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produtoCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoListagemDTO> alterar(@RequestBody ProdutoAtualizacaoDTO produto, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(produtoService.alterar(produto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
