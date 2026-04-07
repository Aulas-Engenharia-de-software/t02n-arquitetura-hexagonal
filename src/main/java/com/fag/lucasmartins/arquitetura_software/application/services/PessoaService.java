package com.fag.lucasmartins.arquitetura_software.application.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort repository;

    public PessoaService(PessoaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        if (pessoaBO.getId() == null) {
            pessoaBO.setId(UUID.randomUUID());
        }

        pessoaBO.validarDadosPessoa();

        return repository.salvar(pessoaBO);
    }
}