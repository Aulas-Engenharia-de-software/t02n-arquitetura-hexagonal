package com.fag.lucasmartins.arquitetura_software.application.services;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort pessoaRepositoryPort;

    public PessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        this.pessoaRepositoryPort = pessoaRepositoryPort;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        pessoaBO.validarDados();
        return pessoaRepositoryPort.salvar(pessoaBO);
    }

    @Override
    public PessoaBO buscarPorId(UUID id){
        return pessoaRepositoryPort.buscarPorId(id).orElseThrow(() -> new DomainException("Pessoa não encontrada"));
    }

    @Override
    public List<PessoaBO> buscarTodos(){
        return pessoaRepositoryPort.buscarTodos();
    }
}
