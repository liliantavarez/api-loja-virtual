package com.dev.api.services;

import com.dev.api.dto.EstadoDTO;
import com.dev.api.entities.Estado;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;
    private final ModelMapper modelMapper;

    public EstadoService(EstadoRepository estadoRepository, ModelMapper modelMapper) {
        this.estadoRepository = estadoRepository;
        this.modelMapper = modelMapper;
    }

    public List<EstadoDTO> buscarTodos() {
        return estadoRepository.findAll()
                .stream()
                .map(estado -> modelMapper.map(estado, EstadoDTO.class))
                .toList();
    }

    public Estado inserir(EstadoDTO estadoDTO) {
        Estado estado = estadoRepository.save(modelMapper.map(estadoDTO, Estado.class));
        estado.setDataCriacao(new Date());
    return estado;
    }

    public Estado alterar(EstadoDTO estadoDTO, Long id) {
        return estadoRepository.findById(id).map(estado -> {
            if (estadoDTO.getNome() != null) {
                estado.setNome(estadoDTO.getNome());
            }
            if (estadoDTO.getSigla() != null) {
                estado.setSigla(estadoDTO.getSigla());
            }

            estado.setDataAtualizacao(new Date());
            return estadoRepository.save(estado);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        estadoRepository.delete(estadoRepository
                .findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado( id)));
    }
}
