package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.messaging.saidaestoque.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.event.SaidaEstoqueEvent;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.messaging.saidaestoque.dto.SaidaEstoqueEventDTO;

public class SaidaEstoqueDTOMapper {

    private SaidaEstoqueDTOMapper() {
    }

    public static SaidaEstoqueEventDTO toDto(SaidaEstoqueEvent evento) {
        return new SaidaEstoqueEventDTO(
                evento.getProdutoId(),
                evento.getQuantidade()
        );
    }
}
