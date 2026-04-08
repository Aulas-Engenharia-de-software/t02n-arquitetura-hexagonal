package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import com.fag.lucasmartins.arquitetura_software.core.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper.PessoaMapper;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@Component
public class PessoaRepositoryPortAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository jpaRepository;
    private final PessoaMapper mapper;

    public PessoaRepositoryPortAdapter(PessoaJpaRepository jpaRepository, PessoaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoa) {
        PessoaEntity entity = mapper.toEntity(pessoa);
        PessoaEntity saved = jpaRepository.save(entity);
        return mapper.toBO(saved);
    }

    @Override
    public Optional<PessoaBO> buscarPorId(UUID id) {
        return jpaRepository.findById(id).map(mapper::toBO);
    }
}