package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaServicePort servicePort;

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody PessoaRequestDTO dto) {
        try {
            return ResponseEntity.ok(servicePort.cadastrar(PessoaMapper.toBO(dto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}