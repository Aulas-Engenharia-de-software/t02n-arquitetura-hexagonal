package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.core.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaControllerAdapter {

    private final PessoaServicePort pessoaService;
    private final PessoaDTOMapper mapper;

    public PessoaControllerAdapter(PessoaServicePort pessoaService, PessoaDTOMapper mapper) {
        this.pessoaService = pessoaService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> cadastrar(@RequestBody PessoaRequestDTO request) {
        PessoaBO bo = mapper.toBO(request);
        PessoaBO saved = pessoaService.cadastrar(bo);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarPorId(@PathVariable UUID id) {
        return pessoaService.buscarPorId(id)
                .map(mapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tratamento local para DomainException (se não houver um GlobalExceptionHandler)
    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleDomainException(DomainException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}