package com.dev.api.services;

import com.dev.api.dto.CategoriaDTO;
import com.dev.api.entities.Categoria;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    public List<CategoriaDTO> buscarTodos() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
                .toList();
    }

    public CategoriaDTO inserir(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        return modelMapper.map(categoriaRepository.save(categoria), CategoriaDTO.class);
    }

    public CategoriaDTO alterar(Categoria categoriaAtualizada, Long id) {
        return categoriaRepository.findById(id).map(categoria -> {
            if (categoriaAtualizada.getNome() != null) {
                categoria.setNome(categoriaAtualizada.getNome());
            }
            categoria.setDataAtualizacao(new Date());
            return modelMapper.map(categoriaRepository.save(categoria), CategoriaDTO.class);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        categoriaRepository
                .delete(categoriaRepository
                        .findById(id)
                        .orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
