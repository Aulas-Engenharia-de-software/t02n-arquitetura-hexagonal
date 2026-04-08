package com.fag.lucasmartins.arquitetura_software.core.application.ports.in.service;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import java.util.Optional;
import java.util.UUID;

public interface PessoaServicePort {
    PessoaBO cadastrar(PessoaBO pessoa);
    Optional<PessoaBO> buscarPorId(UUID id);
}