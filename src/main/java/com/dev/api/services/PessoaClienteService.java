package com.dev.api.services;

import com.dev.api.dto.PessoaClienteRequestDTO;
import com.dev.api.dto.PessoaDTO;
import com.dev.api.entities.Pessoa;
import com.dev.api.repositories.PessoaClienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PessoaClienteService {

    private final PessoaClienteRepository pessoaRepository;
    private final PermissaoPessoaService permissaoPessoaService;
    private final ModelMapper modelMapper;

    public PessoaDTO cadastrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = modelMapper.map(pessoaClienteRequestDTO, Pessoa.class);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        permissaoPessoaService.vincularPessoaPermissoaCliente(pessoaSalva);

        return modelMapper.map(pessoaSalva, PessoaDTO.class);
    }

}
