package com.fag.lucasmartins.arquitetura_software.core.application.ports.out.persistence;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import java.util.Optional;
import java.util.UUID;

public interface PessoaRepositoryPort {
    PessoaBO salvar(PessoaBO pessoa);
    Optional<PessoaBO> buscarPorId(UUID id);
}