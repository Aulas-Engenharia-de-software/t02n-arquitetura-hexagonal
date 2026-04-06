package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

import java.util.UUID;

public class PessoaDTOMapper {

    public static PessoaBO toBO(PessoaDTO dto) {

        PessoaBO pessoa = new PessoaBO();

        pessoa.setId(UUID.randomUUID());
        pessoa.setNomeCompleto(dto.nomeCompleto);
        pessoa.setCpf(dto.cpf);
        pessoa.setDataNascimento(dto.dataNascimento);
        pessoa.setEmail(dto.email);
        pessoa.setTelefone(dto.telefone);

        return pessoa;
    }
}