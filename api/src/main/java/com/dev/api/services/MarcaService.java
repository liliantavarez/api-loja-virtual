package com.dev.api.services;

import com.dev.api.dto.MarcaDTO;
import com.dev.api.entities.Marca;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.MarcaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    MarcaRepository marcaRepository;
    ModelMapper modelMapper;

    public MarcaService(MarcaRepository marcaRepository, ModelMapper modelMapper) {
        this.marcaRepository = marcaRepository;
        this.modelMapper = modelMapper;
    }

    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        return marcaRepository.save(marca);
    }

    public Marca alterar(Marca marcaAtualizada, Long id) {
        return marcaRepository.findById(id).map(marca -> {
            if (marcaAtualizada.getNome() != null) {
                marca.setNome(marcaAtualizada.getNome());
            }
            marca.setDataAtualizacao(new Date());
            return marcaRepository.save(marca);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        marcaRepository.delete(
                marcaRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

}