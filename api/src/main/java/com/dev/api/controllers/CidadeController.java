package com.dev.api.controllers;

import com.dev.api.dto.CidadeDTO;
import com.dev.api.entities.Cidade;
import com.dev.api.services.CidadeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @PostMapping
    public ResponseEntity<Cidade> inserir(@RequestBody @Valid CidadeDTO cidadeDTO, UriComponentsBuilder uriComponentsBuilder) {
        Cidade cidade = cidadeService.inserir(cidadeDTO);
        var uri = uriComponentsBuilder.path("/cidade/{id}").buildAndExpand(cidade.getId()).toUri();
        return ResponseEntity.created(uri).body(cidade);
    }

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> buscarTodos() {
        return ResponseEntity.ok(cidadeService.buscarTodos());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cidade> alterar(@RequestBody CidadeDTO cidadeDTO, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(cidadeService.alterar(cidadeDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        cidadeService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
