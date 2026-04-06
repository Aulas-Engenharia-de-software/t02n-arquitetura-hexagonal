package com.fag.lucasmartins.arquitetura_software.application.services;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort repository;

    public PessoaService(PessoaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PessoaBO cadastrar(PessoaBO pessoa) {
        // A validação já acontece dentro do construtor do PessoaBO
        // O service só chama o repositório
        return repository.salvar(pessoa);
    }
}