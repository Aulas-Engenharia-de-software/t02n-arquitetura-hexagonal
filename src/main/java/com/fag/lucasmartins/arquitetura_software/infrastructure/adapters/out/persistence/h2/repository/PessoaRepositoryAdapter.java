package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {
    @Autowired
    private PessoaJpaRepository jpaRepository;

    @Override
    public PessoaBO salvar(PessoaBO bo) {
        PessoaEntity entity = new PessoaEntity();
        entity.setId(bo.getId());
        entity.setNome(bo.getNomeCompleto());
        entity.setCpf(bo.getCpf());
        entity.setDataNascimento(bo.getDataNascimento());
        entity.setEmail(bo.getEmail());
        entity.setTelefone(bo.getTelefone());
        
        jpaRepository.save(entity);
        return bo;
    }
}