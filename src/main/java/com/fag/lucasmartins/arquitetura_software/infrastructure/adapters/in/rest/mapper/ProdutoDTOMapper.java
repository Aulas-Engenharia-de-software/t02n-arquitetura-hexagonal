package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.ProdutoDTO;

public class ProdutoDTOMapper {

    public static ProdutoBO toBo(ProdutoDTO dto) {
        ProdutoBO bo = new ProdutoBO();
        bo.setNome(dto.getNome());
        bo.setPreco(dto.getPreco());
        bo.setEstoque(dto.getEstoque());
        return bo;
    }

    public static ProdutoDTO toDto(ProdutoBO bo) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setNome(bo.getNome());
        dto.setPreco(bo.getPreco());
        dto.setEstoque(bo.getEstoque());
        
        return dto;
    }
}