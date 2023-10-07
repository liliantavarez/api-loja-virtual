package com.dev.api.services;

import com.dev.api.dto.MarcaDTO;
import com.dev.api.entities.Marca;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.MarcaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;
    private final ModelMapper modelMapper;

    public List<MarcaDTO> buscarTodos() {
        return marcaRepository.findAll()
                .stream()
                .map(marca -> modelMapper.map(marca, MarcaDTO.class))
                .toList();
    }

    public MarcaDTO inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        return modelMapper.map(marcaRepository.save(marca), MarcaDTO.class);
    }

    public MarcaDTO alterar(Marca marcaAtualizada, Long id) {
        return marcaRepository.findById(id).map(marca -> {
            if (marcaAtualizada.getNome() != null) {
                marca.setNome(marcaAtualizada.getNome());
            }
            marca.setDataAtualizacao(new Date());
            return modelMapper.map(marcaRepository.save(marca), MarcaDTO.class);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        marcaRepository.delete(
                marcaRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

}