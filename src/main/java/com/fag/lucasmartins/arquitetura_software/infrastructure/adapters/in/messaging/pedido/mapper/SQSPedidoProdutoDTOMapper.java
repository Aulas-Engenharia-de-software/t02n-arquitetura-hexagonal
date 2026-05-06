package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.SQSPedidoProdutoDTO;

public class SQSPedidoProdutoDTOMapper {

    private SQSPedidoProdutoDTOMapper() {
    }

    public static PedidoProdutoBO toBo(SQSPedidoProdutoDTO sqsPedidoProdutoDTO) {
        final PedidoProdutoBO pedidoProdutoBO = new PedidoProdutoBO();
        final ProdutoBO produtoBO = SQSProdutoMessagingDTOMapper.toBo(sqsPedidoProdutoDTO);

        pedidoProdutoBO.setProduto(produtoBO);
        pedidoProdutoBO.setQuantidade(sqsPedidoProdutoDTO.getAmount());

        return pedidoProdutoBO;
    }
}
