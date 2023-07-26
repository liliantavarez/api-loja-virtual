package com.dev.api.services;

import com.dev.api.entities.Produto;
import com.dev.api.entities.ProdutoImagens;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.ProdutoImagensRepository;
import com.dev.api.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoImagensService {

    private final ProdutoImagensRepository produtoImagensRepository;
    private final ProdutoRepository produtoRepository;


    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) throws RuntimeException {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RegistroNaoEncontrado(idProduto));
        ProdutoImagens objeto = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId() + file.getOriginalFilename());
                Path caminho = Paths.get("C:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);

                objeto.setNome(nomeImagem);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());

        return produtoImagensRepository.save(objeto);
    }

    public ProdutoImagens alterar(ProdutoImagens produtoImagensAtualizda, Long id) {
        return produtoImagensRepository.findById(id).map(produtoImagens -> {
            if (produtoImagensAtualizda.getNome() != null) {
                produtoImagens.setNome(produtoImagensAtualizda.getNome());
            }
            produtoImagens.setDataAtualizacao(new Date());
            return produtoImagensRepository.save(produtoImagens);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void excluir(Long id) {
        produtoImagensRepository
                .delete(produtoImagensRepository
                        .findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
