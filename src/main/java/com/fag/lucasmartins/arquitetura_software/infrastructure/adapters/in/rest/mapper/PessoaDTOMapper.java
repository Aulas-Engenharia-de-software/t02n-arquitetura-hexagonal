package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

public class PessoaDTOMapper {

    public static PessoaBO toBO(PessoaDTO dto) {
        PessoaBO bo = new PessoaBO();
        bo.setNomeCompleto(dto.getNomeCompleto());
        bo.setDocumentoCpf(dto.getDocumentoCpf());
        bo.setDataNascimento(dto.getDataNascimento());
        bo.setEmailContato(dto.getEmailContato());
        bo.setTelefoneCelular(dto.getTelefoneCelular());
        return bo;
    }

    public static PessoaDTO toDTO(PessoaBO bo) {
        PessoaDTO dto = new PessoaDTO();
        dto.setNomeCompleto(bo.getNomeCompleto());
        dto.setDocumentoCpf(bo.getDocumentoCpf());
        dto.setDataNascimento(bo.getDataNascimento());
        dto.setEmailContato(bo.getEmailContato());
        dto.setTelefoneCelular(bo.getTelefoneCelular());
        return dto;
    }
}