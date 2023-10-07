package com.dev.api.services;

import com.dev.api.dto.ProdutoAtualizacaoDTO;
import com.dev.api.dto.ProdutoListagemDTO;
import com.dev.api.entities.Produto;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    ProdutoRepository produtoRepository;
    ModelMapper modelMapper;


    public List<ProdutoListagemDTO> buscarTodos() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(produto -> modelMapper.map(produto, ProdutoListagemDTO.class)).toList();
    }

    public ProdutoListagemDTO inserir(Produto produto) {
        produto.setDataCriacao(new Date());
        return modelMapper.map(produtoRepository.save(produto), ProdutoListagemDTO.class);
    }

    public ProdutoListagemDTO alterar(ProdutoAtualizacaoDTO produtoAtualizacaoDTO, Long id) {
        return produtoRepository.findById(id).map(produto -> {
            if (produtoAtualizacaoDTO.getNome() != null) {
                produto.setNome(produtoAtualizacaoDTO.getNome());
            }
            if (produtoAtualizacaoDTO.getDescricaoCurta() != null) {
                produto.setDescricaoCurta(produtoAtualizacaoDTO.getDescricaoCurta());
            }
            if (produtoAtualizacaoDTO.getDescricaoDetalhada() != null) {
                produto.setDescricaoDetalhada(produtoAtualizacaoDTO.getDescricaoDetalhada());
            }
            if (produtoAtualizacaoDTO.getValorCusto() != null) {
                produto.setValorCusto(produtoAtualizacaoDTO.getValorCusto());
            }
            if (produtoAtualizacaoDTO.getValorVenda() != null) {
                produto.setValorVenda(produtoAtualizacaoDTO.getValorVenda());
            }
            produto.setDataAtualizacao(new Date());
            Produto produtoAtualizado = produtoRepository.save(produto);
            return modelMapper.map(produtoAtualizado, ProdutoListagemDTO.class);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));

    }

    public void excluir(Long id) {
        produtoRepository
                .delete(produtoRepository
                        .findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
