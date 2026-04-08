package com.fag.lucasmartins.arquitetura_software.core.application.services;

import com.fag.lucasmartins.arquitetura_software.core.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort repository;

    public PessoaService(PessoaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PessoaBO cadastrar(PessoaBO pessoa) {
        return repository.salvar(pessoa);
    }

    @Override
    public Optional<PessoaBO> buscarPorId(UUID id) {
        return repository.buscarPorId(id);
    }
}