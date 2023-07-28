package com.dev.api.controllers;

import com.dev.api.dto.CidadeDTO;
import com.dev.api.dto.CidadeListagemDTO;
import com.dev.api.entities.Cidade;
import com.dev.api.services.CidadeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@AllArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;


    @PostMapping
    public ResponseEntity<CidadeDTO> inserir(@RequestBody @Valid Cidade cidade, UriComponentsBuilder uriComponentsBuilder) {
        CidadeDTO cidadeDTO = cidadeService.inserir(cidade);
        var uri = uriComponentsBuilder.path("/cidade/{id}").buildAndExpand(cidade.getId()).toUri();
        return ResponseEntity.created(uri).body(cidadeDTO);
    }

    @GetMapping
    public ResponseEntity<List<CidadeListagemDTO>> buscarTodos() {
        return ResponseEntity.ok(cidadeService.buscarTodos());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CidadeDTO> alterar(@RequestBody Cidade cidade, @PathVariable @NotNull Long id) {
        return ResponseEntity.ok(cidadeService.alterar(cidade, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id) {
        cidadeService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
