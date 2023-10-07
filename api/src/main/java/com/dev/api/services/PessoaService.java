package com.dev.api.services;

import com.dev.api.dto.PessoaDTO;
import com.dev.api.dto.PessoaListagemDTO;
import com.dev.api.entities.Pessoa;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;


    public List<PessoaListagemDTO> buscarTodos() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> modelMapper.map(pessoa, PessoaListagemDTO.class)).toList();
    }

    public PessoaDTO inserir(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        return modelMapper.map(pessoaRepository.save(pessoa), PessoaDTO.class);
    }

    public Pessoa atualizar(PessoaDTO pessoaDTO, Long id) {
        return pessoaRepository.findById(id).map(pessoa -> {
            if (pessoa.getNome() != null) {
                pessoa.setNome(pessoaDTO.getNome());
            }
            if (pessoa.getCpf() != null) {
                pessoa.setCpf(pessoaDTO.getCpf());
            }
            if (pessoa.getEmail() != null) {
                pessoa.setEmail(pessoaDTO.getEmail());
            }
            if (pessoa.getSenha() != null) {
                pessoa.setSenha(pessoaDTO.getSenha());
            }
            if (pessoa.getEndereco() != null) {
                pessoa.setEndereco(pessoaDTO.getEndereco());
            }
            if (pessoa.getCep() != null) {
                pessoa.setCep(pessoaDTO.getCep());
            }
            if (pessoa.getCidade() != null) {
                pessoa.setCidade(pessoaDTO.getCidade());
            }
            pessoa.setDataAtualizacao(new Date());
            pessoaRepository.save(pessoa);
            return pessoa;
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void remover(Long id) {
        pessoaRepository.delete(
                pessoaRepository
                        .findById(id)
                        .orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

}
