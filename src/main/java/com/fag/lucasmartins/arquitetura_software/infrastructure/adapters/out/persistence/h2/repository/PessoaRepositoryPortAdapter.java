package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper.PessoaMapper;

@Component
public class PessoaRepositoryPortAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository jpaRepository;

    public PessoaRepositoryPortAdapter(PessoaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoa) {
        PessoaEntity entity = PessoaMapper.toEntity(pessoa);
        PessoaEntity saved = jpaRepository.save(entity);
        return PessoaMapper.toBO(saved);
    }
}