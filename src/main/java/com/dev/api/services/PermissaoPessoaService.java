package com.dev.api.services;

import com.dev.api.entities.Permissao;
import com.dev.api.entities.PermissaoPessoa;
import com.dev.api.entities.Pessoa;
import com.dev.api.repositories.PermissaoPessoaRepository;
import com.dev.api.repositories.PermissaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PermissaoPessoaService {

    private final PermissaoPessoaRepository permissaoPessoaRepository;
    private final PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissoaCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");
        if (!listaPermissao.isEmpty()) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.save(permissaoPessoa);
        }
    }
}
