package com.dev.api.services;

import com.dev.api.dto.CidadeDTO;
import com.dev.api.entities.Cidade;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.CidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;
    private final ModelMapper modelMapper;

    public CidadeService(CidadeRepository cidadeRepository, ModelMapper modelMapper) {
        this.cidadeRepository = cidadeRepository;
        this.modelMapper = modelMapper;
    }

    public Cidade inserir(CidadeDTO cidadeDTO) {
        Cidade cidade = cidadeRepository.save(modelMapper.map(cidadeDTO, Cidade.class));
        cidade.setDataCriacao(new Date());
        return cidade;
    }

    public List<CidadeDTO> buscarTodos() {
        return cidadeRepository.findAll()
                .stream()
                .map(cidade -> modelMapper.map(cidade, CidadeDTO.class))
                .toList();
    }

    public Cidade alterar(CidadeDTO cidadeDTO, Long id) {
        return cidadeRepository.findById(id).map(cidade -> {
            if (cidadeDTO.getNome() != null) {
                cidade.setNome(cidadeDTO.getNome());
            }
            if (cidadeDTO.getEstado() != null) {
                cidade.setEstado(cidadeDTO.getEstado());
            }
            cidade.setDataAtualizacao(new Date());
            return cidadeRepository.save(cidade);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        cidadeRepository.delete(cidadeRepository
                .findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

}
