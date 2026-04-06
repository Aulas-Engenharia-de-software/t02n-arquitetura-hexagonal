package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;

public class PessoaDTOMapper {

    public static PessoaBO toBO(PessoaRequestDTO dto) {
        return new PessoaBO(
            null, // id será gerado no BO
            dto.getNomeCompleto(),
            dto.getCpf(),
            dto.getDataNascimento(),
            dto.getEmail(),
            dto.getTelefone()
        );
    }

    public static PessoaResponseDTO toResponse(PessoaBO bo) {
        return new PessoaResponseDTO(
            bo.getId(),
            bo.getNomeCompleto(),
            bo.getCpf(),
            bo.getDataNascimento(),
            bo.getEmail(),
            bo.getTelefone()
        );
    }
}