package com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2;

import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public interface PessoaRepositoryPort {
    PessoaEntity salvar(PessoaEntity pessoa);
}