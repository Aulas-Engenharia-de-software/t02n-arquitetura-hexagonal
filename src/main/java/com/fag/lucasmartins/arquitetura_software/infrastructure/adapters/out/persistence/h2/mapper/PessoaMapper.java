package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {

    private PessoaMapper() {
    }

    public static PessoaEntity toEntity(PessoaBO pessoaBO) {
        PessoaEntity pessoaEntity = new PessoaEntity();

        pessoaEntity.setCpf(pessoaBO.getCpf());
        pessoaEntity.setDataNascimento(pessoaBO.getDataNascimento());
        pessoaEntity.setEmail(pessoaBO.getEmail());
        pessoaEntity.setNomeCompleto(pessoaBO.getNomeCompleto());
        pessoaEntity.setTelefone(pessoaBO.getTelefone());

        return pessoaEntity;
    }

    public static PessoaBO toBO(PessoaEntity pessoaEntity) {
        PessoaBO pessoaBO = new PessoaBO();

        pessoaBO.setCpf(pessoaEntity.getCpf());
        pessoaBO.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoaBO.setEmail(pessoaEntity.getEmail());
        pessoaBO.setNomeCompleto(pessoaEntity.getNomeCompleto());
        pessoaBO.setTelefone(pessoaEntity.getTelefone());

        return pessoaBO;
    }
}
