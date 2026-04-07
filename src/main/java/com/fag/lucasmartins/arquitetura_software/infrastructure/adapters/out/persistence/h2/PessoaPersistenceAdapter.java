package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository.PessoaRepository;
import org.springframework.stereotype.Component;

@Component
public class PessoaPersistenceAdapter implements PessoaRepositoryPort {

    private final PessoaRepository repository;

    public PessoaPersistenceAdapter(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PessoaEntity salvar(PessoaEntity pessoa) {
        return repository.save(pessoa);
    }
}