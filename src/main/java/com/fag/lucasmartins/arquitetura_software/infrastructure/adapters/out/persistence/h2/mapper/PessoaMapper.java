package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {

    private PessoaMapper() {}

    public static PessoaEntity toEntity(PessoaBO pessoaBO) {
        PessoaEntity entity = new PessoaEntity();

        entity.setId(pessoaBO.getId());
        entity.setNomeCompleto(pessoaBO.getNomeCompleto());
        entity.setCpf(pessoaBO.getCpf());
        entity.setDataNascimento(pessoaBO.getDataNascimento());
        entity.setEmail(pessoaBO.getEmail());
        entity.setTelefone(pessoaBO.getTelefone());

        return entity;
    }

    public static PessoaBO toBO(PessoaEntity entity) {
        PessoaBO pessoa = new PessoaBO();

        pessoa.setId(entity.getId());
        pessoa.setNomeCompleto(entity.getNomeCompleto());
        pessoa.setCpf(entity.getCpf());
        pessoa.setDataNascimento(entity.getDataNascimento());
        pessoa.setEmail(entity.getEmail());
        pessoa.setTelefone(entity.getTelefone());

        return pessoa;
    }
}