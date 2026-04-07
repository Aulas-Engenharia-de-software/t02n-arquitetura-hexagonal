package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaServicePort pessoaServicePort;

    public PessoaControllerAdapter(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO){

        PessoaBO pessoaBO = PessoaDTOMapper.toBo(pessoaDTO);

        PessoaBO pessoaCriada = pessoaServicePort.salvar(pessoaBO);

        PessoaDTO dto = PessoaDTOMapper.toDto(pessoaCriada);

        return ResponseEntity.status(201).body(dto);
    }
}