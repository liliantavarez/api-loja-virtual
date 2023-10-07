package com.dev.api.controllers;

import com.dev.api.entities.ProdutoImagens;
import com.dev.api.services.ProdutoImagensService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/produto-imagens")
@AllArgsConstructor
public class ProdutoImagensController {

    private final ProdutoImagensService produtoImagensService;


    @GetMapping
    ResponseEntity<List<ProdutoImagens>> buscarTodos() {
        return ResponseEntity.ok(produtoImagensService.buscarTodos());
    }

    @PostMapping
    ResponseEntity<ProdutoImagens> inserir(@RequestParam("produto_id") Long idProduto, @RequestParam("file") MultipartFile file, UriComponentsBuilder uriComponentsBuilder) {
        ProdutoImagens imagemCriada = produtoImagensService.inserir(idProduto, file);
        var uri = uriComponentsBuilder.path("/imagens/{id}").buildAndExpand(imagemCriada.getId()).toUri();

        return ResponseEntity.created(uri).body(imagemCriada);
    }

    @PatchMapping("/{id}")
    ResponseEntity<ProdutoImagens> alterar(@RequestBody ProdutoImagens imagem, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(produtoImagensService.alterar(imagem, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        produtoImagensService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
