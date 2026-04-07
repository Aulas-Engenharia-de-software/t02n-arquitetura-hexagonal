package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import org.springframework.stereotype.Repository;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;

@Repository
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository repository;

    public PessoaRepositoryAdapter(PessoaJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PessoaBO salvar(PessoaBO bo) {
        PessoaEntity entity = new PessoaEntity();
        
      
        entity.setId(bo.getId());
        entity.setNome(bo.getNomeCompleto());
        entity.setCpf(bo.getDocumentoCpf());
        entity.setDataNascimento(bo.getDataNascimento());
        entity.setEmail(bo.getEmailContato());
        entity.setTelefone(bo.getTelefoneCelular());

        repository.save(entity);
        
        return bo; 
    }
}