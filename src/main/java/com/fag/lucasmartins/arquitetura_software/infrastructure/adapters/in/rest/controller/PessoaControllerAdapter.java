package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.services.PessoaService;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaService service;

    public PessoaControllerAdapter(PessoaService service) {
        this.service = service;
    }


@PostMapping
public Object cadastrar(@RequestBody PessoaDTO dto) {
    return service.cadastrar(dto);
}
}