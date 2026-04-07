package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;

public class PessoaMapper {
    public static PessoaBO toBO(PessoaRequestDTO dto) {
        return new PessoaBO(
            null, // ID gerado no BO
            dto.getNomeCompleto(),
            dto.getCpf(),
            dto.getDataNascimento(),
            dto.getEmail(),
            dto.getTelefone()
        );
    }
}