package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

public class PessoaDTOMapper {

    private PessoaDTOMapper() {
    }

    public static PessoaBO toBO(PessoaDTO pessoaDTO) {
        PessoaBO pessoaBO = new PessoaBO();

        pessoaBO.setCpf(pessoaDTO.getCpf());
        pessoaBO.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoaBO.setEmail(pessoaDTO.getEmail());
        pessoaBO.setNomeCompleto(pessoaDTO.getNomeCompleto());
        pessoaBO.setTelefone(pessoaDTO.getTelefone());

        return pessoaBO;
    }

    public static PessoaDTO toDTO(PessoaBO pessoaBO) {
        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setCpf(pessoaBO.getCpf());
        pessoaDTO.setDataNascimento(pessoaBO.getDataNascimento());
        pessoaDTO.setEmail(pessoaBO.getEmail());
        pessoaDTO.setNomeCompleto(pessoaBO.getNomeCompleto());
        pessoaDTO.setTelefone(pessoaBO.getTelefone());

        return pessoaDTO;
    }
}
