package com.dev.api.services;

import com.dev.api.dto.PessoaDTO;
import com.dev.api.dto.request.PessoaClienteRequestDTO;
import com.dev.api.entities.Pessoa;
import com.dev.api.exceptions.RegistroNaoEncontrado;
import com.dev.api.repositories.PessoaClienteRepository;
import com.dev.api.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PessoaGerenciamentoService {

    private final PessoaRepository pessoaRepository;
    private final EmailService emailService;

    public String solicitarCodigo(String email) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(gerarCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());

        pessoaRepository.save(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Codigo de recuperação de senha", "Olá, o seu codigo para recuperação de senha é o seguinte: " + pessoa.getCodigoRecuperacaoSenha());

        return "Código Enviado!";
    }

    private String gerarCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");

        return format.format(new Date()) + id;
    }


    public String alterarSenha(PessoaDTO pessoaDTO) {
        Pessoa pessoaBanco = pessoaRepository.findByEmailAndAndCodigoRecuperacaoSenha(pessoaDTO.getEmail(), pessoaDTO.getCodigoRecuperacaoSenha());
        if (pessoaBanco != null) {
            Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());
            if (diferenca.getTime() / 1000 < 900) {
                pessoaBanco.setSenha(pessoaDTO.getSenha());
                pessoaBanco.setCodigoRecuperacaoSenha(null);
                pessoaRepository.save(pessoaBanco);

                return "Senha alterada com sucesso!";
            } else {
                return "Tempo expirado, solicite um novo codigo";
            }
        }
        return "";
    }

}
