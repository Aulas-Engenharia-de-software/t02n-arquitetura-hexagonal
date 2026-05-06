package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventDTO;

import java.util.ArrayList;
import java.util.List;


public class PedidoEventDTOMapper {

    private PedidoEventDTOMapper() {
    }

    public static PedidoBO toBo(PedidoEventDTO dto) {

        final PessoaBO pessoaBO = new PessoaBO();
        pessoaBO.setId(dto.getCustomerId());

        final List<PedidoProdutoBO> itens = new ArrayList<>();
        for (PedidoEventDTO.OrderItemDTO itemDTO : dto.getOrderItems()) {

            final ProdutoBO produtoBO = new ProdutoBO();
            produtoBO.setId(itemDTO.getSku());

            final PedidoProdutoBO itemBO = new PedidoProdutoBO();
            itemBO.setProduto(produtoBO);
            itemBO.setQuantidade(itemDTO.getAmount());

            itens.add(itemBO);
        }

        final PedidoBO pedidoBO = new PedidoBO();
        pedidoBO.setPessoa(pessoaBO);
        pedidoBO.setCep(dto.getZipCode());
        pedidoBO.setItens(itens);

        return pedidoBO;
    }
}