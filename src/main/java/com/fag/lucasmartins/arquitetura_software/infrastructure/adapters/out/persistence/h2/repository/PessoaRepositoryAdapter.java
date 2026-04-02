package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository jpaRepository;

    public PessoaRepositoryAdapter(PessoaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO bo) {
        PessoaEntity entity = new PessoaEntity();
        entity.setId(bo.getId());
        entity.setNomeCompleto(bo.getNomeCompleto());
        entity.setCpf(bo.getCpf());
        entity.setDataNascimento(bo.getDataNascimento());
        entity.setEmail(bo.getEmail());
        entity.setTelefone(bo.getTelefone());

        PessoaEntity salva = jpaRepository.save(entity);

        PessoaBO retorno = new PessoaBO();
        retorno.setId(salva.getId());
        retorno.setNomeCompleto(salva.getNomeCompleto());
        retorno.setCpf(salva.getCpf());
        retorno.setDataNascimento(salva.getDataNascimento());
        retorno.setEmail(salva.getEmail());
        retorno.setTelefone(salva.getTelefone());

        return retorno;
    }
}