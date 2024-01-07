package com.dev.api.controllers;

import com.dev.api.dto.request.PessoaClienteRequestDTO;
import com.dev.api.dto.PessoaDTO;
import com.dev.api.entities.Pessoa;
import com.dev.api.services.PessoaClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class PessoaClienteController {

    private final PessoaClienteService pessoaClienteService;
    private final ModelMapper modelMapper;

    @PostMapping
    ResponseEntity<PessoaDTO> cadastrar(@Valid @RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        pessoaClienteService.cadastrar(pessoaClienteRequestDTO);

        Pessoa pessoa = modelMapper.map(pessoaClienteRequestDTO, Pessoa.class);

        var uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(modelMapper.map(pessoa, PessoaDTO.class));
    }

    @GetMapping("/{id}")
    ResponseEntity<PessoaDTO> buscarPorID(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaClienteService.buscarPorID(id));
    }
}
