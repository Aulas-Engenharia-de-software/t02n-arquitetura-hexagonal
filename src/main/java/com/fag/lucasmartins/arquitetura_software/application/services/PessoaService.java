package com.fag.lucasmartins.arquitetura_software.application.services;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort repository;
    private final PessoaBO pessoaBO;

    public PessoaService(PessoaRepositoryPort repository) {
        this.repository = repository;
        this.pessoaBO = new PessoaBO();
    }

    @Override
    public PessoaDTO criarPessoa(PessoaDTO dto) {
        pessoaBO.validar(dto);

        PessoaEntity entity = new PessoaEntity();
        entity.setId(UUID.randomUUID());
        entity.setNomeCompleto(dto.getNomeCompleto());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());

        PessoaEntity salva = repository.salvar(entity);

        return new PessoaDTO(
                salva.getId(),
                salva.getNomeCompleto(),
                salva.getCpf(),
                salva.getDataNascimento(),
                salva.getEmail(),
                salva.getTelefone()
        );
    }
}