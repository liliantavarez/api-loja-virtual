package com.dev.api.controllers;

import com.dev.api.dto.PessoaDTO;
import com.dev.api.dto.request.CodigoRecuperaSenhaRequestDTO;
import com.dev.api.services.PessoaGerenciamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")
@AllArgsConstructor
public class PessoaGerenciamentoController {

    private final PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/senha-codigo")
    ResponseEntity<String> recuperarCodigo(@RequestBody CodigoRecuperaSenhaRequestDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaGerenciamentoService.solicitarCodigo(pessoaDTO.getEmail()));
    }

    @PostMapping("/senha-alterar")
    ResponseEntity<String> alterarSenha(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaGerenciamentoService.alterarSenha(pessoaDTO));
    }

}
