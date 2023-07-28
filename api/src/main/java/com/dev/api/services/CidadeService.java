package com.dev.api.services;

import com.dev.api.dto.CidadeDTO;
import com.dev.api.dto.CidadeListagemDTO;
import com.dev.api.entities.Cidade;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.CidadeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;
    private final ModelMapper modelMapper;

    public CidadeDTO inserir(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        return modelMapper.map(cidadeRepository.save(cidade), CidadeDTO.class);
    }

    public List<CidadeListagemDTO> buscarTodos() {
        return cidadeRepository.findAll()
                .stream()
                .map(cidade -> modelMapper.map(cidade, CidadeListagemDTO.class))
                .toList();
    }

    public CidadeDTO alterar(Cidade cidadeDTO, Long id) {
        return cidadeRepository.findById(id).map(cidade -> {
            cidade.setNome(cidadeDTO.getNome());
            if (cidadeDTO.getEstado() != null) {
                cidade.setEstado(cidadeDTO.getEstado());
            }
            cidade.setDataAtualizacao(new Date());
            return modelMapper.map(cidadeRepository.save(cidade), CidadeDTO.class);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        cidadeRepository.delete(cidadeRepository
                .findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

}
