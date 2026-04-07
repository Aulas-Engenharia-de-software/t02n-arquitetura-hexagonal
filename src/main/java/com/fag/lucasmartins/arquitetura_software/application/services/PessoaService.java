package com.fag.lucasmartins.arquitetura_software.application.services;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort pessoaRepositoryPort;

    public PessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        this.pessoaRepositoryPort = pessoaRepositoryPort;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        // Se id for null, gerar UUID
        if (pessoaBO.getId() == null) {
            pessoaBO.setId(UUID.randomUUID());
        }
        // Validações já são feitas no construtor de PessoaBO, mas podemos chamar validar() se necessário
        pessoaBO.validar();

        return pessoaRepositoryPort.salvar(pessoaBO);
    }
}