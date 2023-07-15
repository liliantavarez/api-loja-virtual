package com.dev.api.services;

import com.dev.api.entities.Categoria;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.CategoriaRepository;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        return categoriaRepository.save(categoria);
    }

    public Categoria alterar(Categoria categoriaAtualizada, Long id) {
        return categoriaRepository.findById(id).map(categoria -> {
            if (categoriaAtualizada.getNome() != null) {
                categoria.setNome(categoriaAtualizada.getNome());
            }
            categoria.setDataAtualizacao(new Date());
            return categoriaRepository.save(categoria);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        categoriaRepository
                .delete(categoriaRepository
                        .findById(id)
                        .orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
