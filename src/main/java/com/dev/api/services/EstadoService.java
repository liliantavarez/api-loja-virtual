package com.dev.api.services;

import com.dev.api.dto.EstadoDTO;
import com.dev.api.entities.Estado;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.EstadoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;
    private final ModelMapper modelMapper;


    public List<EstadoDTO> buscarTodos() {
        return estadoRepository.findAll()
                .stream()
                .map(estado -> modelMapper.map(estado, EstadoDTO.class))
                .toList();
    }

    public EstadoDTO inserir(Estado estado) {
        estado.setDataCriacao(new Date());
        return modelMapper.map(estadoRepository.save(estado), EstadoDTO.class);
    }

    public EstadoDTO alterar(Estado estadoAtualizado, Long id) {
        return estadoRepository.findById(id).map(estado -> {
            estado.setNome(estadoAtualizado.getNome());
            if (estado.getSigla() == null) {
                estado.setSigla(estadoAtualizado.getSigla());
            }

            estado.setDataAtualizacao(new Date());
            return modelMapper.map(estadoRepository.save(estado), EstadoDTO.class);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        estadoRepository.delete(estadoRepository
                .findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
