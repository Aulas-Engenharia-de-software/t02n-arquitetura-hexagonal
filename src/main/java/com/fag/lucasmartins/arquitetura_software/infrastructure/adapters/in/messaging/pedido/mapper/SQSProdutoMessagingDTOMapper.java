package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.SQSPedidoProdutoDTO;

public class SQSProdutoMessagingDTOMapper {

    private SQSProdutoMessagingDTOMapper() {
    }

    public static ProdutoBO toBo(SQSPedidoProdutoDTO sqsPedidoProdutoDTO) {
        final ProdutoBO produtoBO = new ProdutoBO();
        produtoBO.setId(sqsPedidoProdutoDTO.getSku());
        return produtoBO;
    }
}
