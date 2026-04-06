package com.fag.lucasmartins.arquitetura_software.application.services;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaService implements PessoaServicePort{

    private final PessoaRepositoryPort repository;

    public PessoaService(PessoaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PessoaBO cadastrar(PessoaDTO dto) {

        PessoaBO pessoa = new PessoaBO();

        pessoa.setId(UUID.randomUUID());
        pessoa.setNomeCompleto(dto.nomeCompleto);
        pessoa.setCpf(dto.cpf);
        pessoa.setDataNascimento(dto.dataNascimento);
        pessoa.setEmail(dto.email);
        pessoa.setTelefone(dto.telefone);

        pessoa.validarDadosPessoa();

        return repository.salvar(pessoa);
    }
}