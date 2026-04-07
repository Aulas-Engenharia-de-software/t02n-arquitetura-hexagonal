package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaServicePort service;

    public PessoaControllerAdapter(PessoaServicePort service) {
        this.service = service;
    }

    @PostMapping
    public PessoaDTO criar(@RequestBody PessoaDTO dto) {
        return service.criarPessoa(dto);
    }
}