package com.dev.api.services;

import com.dev.api.dto.PermissaoDTO;
import com.dev.api.entities.Permissao;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.PermissaoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;
    private final ModelMapper modelMapper;


    public List<PermissaoDTO> buscarTodos() {
        return permissaoRepository.findAll().stream().map(permissao -> modelMapper.map(permissao, PermissaoDTO.class)).toList();
    }

    public Permissao inserir(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        return permissaoRepository.save(permissao);
    }

    public Permissao alterar(Permissao permissaoAtualizada, Long id) {
        return permissaoRepository.findById(id).map(permissao -> {
            if (permissaoAtualizada.getNome() != null) {
                permissao.setNome(permissaoAtualizada.getNome());
            }
            permissao.setDataAtualizacao(new Date());
            return permissaoRepository.save(permissao);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        permissaoRepository
                .delete(permissaoRepository
                        .findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
