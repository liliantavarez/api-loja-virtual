package com.dev.api.controllers;

import com.dev.api.dto.PessoaDTO;
import com.dev.api.dto.PessoaListagemDTO;
import com.dev.api.entities.Pessoa;
import com.dev.api.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    ResponseEntity<List<PessoaListagemDTO>> buscarTodos() {
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    @PostMapping
    ResponseEntity<Pessoa> inserir(@Valid @RequestBody PessoaDTO pessoaDTO, UriComponentsBuilder uriComponentsBuilder) {
        Pessoa pessoa = pessoaService.inserir(pessoaDTO);

        var uri = uriComponentsBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoa);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Pessoa> atualizar(@Valid @RequestBody PessoaDTO pessoaDTO, @PathVariable Long id) {
        Pessoa pessoaAtualizada = pessoaService.atualizar(pessoaDTO, id);

        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoaService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
