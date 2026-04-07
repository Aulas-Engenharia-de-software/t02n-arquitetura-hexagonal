package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;
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
    public ResponseEntity<PessoaResponseDTO> cadastrarPessoa(@RequestBody PessoaRequestDTO pessoaRequestDTO) {
        PessoaBO pessoaBO = PessoaDTOMapper.toBo(pessoaRequestDTO);
        PessoaBO pessoaCriada = pessoaServicePort.salvar(pessoaBO);
        PessoaResponseDTO responseDTO = PessoaDTOMapper.toDto(pessoaCriada);
        return ResponseEntity.status(201).body(responseDTO);
    }
}
