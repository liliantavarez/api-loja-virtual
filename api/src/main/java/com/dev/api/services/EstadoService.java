package com.dev.api.services;

import com.dev.api.dto.EstadoDTO;
import com.dev.api.entities.Estado;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<List<EstadoDTO>> buscarTodos() {
        return ResponseEntity.ok(estadoRepository.findAll().stream().map(estado -> modelMapper.map(estado, EstadoDTO.class)).toList());
    }

    public ResponseEntity<Estado> inserir(EstadoDTO estadoDTO, UriComponentsBuilder uriComponentsBuilder) {
        Estado estado = estadoRepository.save(modelMapper.map(estadoDTO, Estado.class));
        estado.setDataCriacao(new Date());
        var uri = uriComponentsBuilder.path("/estado/{id}").buildAndExpand(estado.getId()).toUri();

        return ResponseEntity.created(uri).body(estado);
    }

    public ResponseEntity<Estado> alterar(EstadoDTO estadoDTO, Long id) {
        return estadoRepository.findById(id).map(estado -> {
            if (estadoDTO.getNome() != null) {
                estado.setNome(estadoDTO.getNome());
            }
            if (estadoDTO.getSigla() != null) {
                estado.setSigla(estadoDTO.getSigla());
            }

            estado.setDataAtualizacao(new Date());
            return ResponseEntity.ok(estadoRepository.save(estado));
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public ResponseEntity excluir(Long id) {
        estadoRepository.delete(estadoRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));

        return ResponseEntity.noContent().build();
    }
}
