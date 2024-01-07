package com.dev.api.services;

import com.dev.api.dto.request.PessoaClienteRequestDTO;
import com.dev.api.dto.PessoaDTO;
import com.dev.api.entities.Pessoa;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.PessoaClienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PessoaClienteService {

    private final PessoaClienteRepository pessoaClienteRepository;
    private final PermissaoPessoaService permissaoPessoaService;
    private final ModelMapper modelMapper;
    private final EmailService emailService;

    public PessoaDTO cadastrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = modelMapper.map(pessoaClienteRequestDTO, Pessoa.class);
        Pessoa pessoaSalva = pessoaClienteRepository.save(pessoa);
        permissaoPessoaService.vincularPessoaPermissoaCliente(pessoaSalva);

        Map<String, Object> propMap = new HashMap<>();
        propMap.put("nome", pessoa.getNome());
        propMap.put("mensagem", "Seu cadastro na loja foi realizado com sucesso! Em breve voce recebera a senha de acesso por e-mail.");
        emailService.enviarEmailTemplate(pessoa.getEmail(), "Cadastro na loja", propMap);

        return modelMapper.map(pessoaSalva, PessoaDTO.class);
    }

    public PessoaDTO buscarPorID(Long id) {
        Pessoa pessoaEncontrada = pessoaClienteRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id));
        return modelMapper.map(pessoaEncontrada, PessoaDTO.class);
    }

}
