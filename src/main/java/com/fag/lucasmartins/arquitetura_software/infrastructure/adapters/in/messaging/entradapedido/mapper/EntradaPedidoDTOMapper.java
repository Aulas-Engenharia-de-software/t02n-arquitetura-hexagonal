package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.EntradaPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.OrderItemEventDTO;

import java.util.ArrayList;
import java.util.List;

public class EntradaPedidoDTOMapper {

    private EntradaPedidoDTOMapper() {
    }

    public static PedidoBO toBo(EntradaPedidoDTO dto) {
        final PedidoBO pedidoBO = new PedidoBO();

        pedidoBO.setCep(dto.getZipCode());

        final PessoaBO pessoaBO = new PessoaBO();
        pessoaBO.setId(dto.getCustomerId());
        pedidoBO.setPessoa(pessoaBO);

        final List<PedidoProdutoBO> itens = new ArrayList<>();
        for (OrderItemEventDTO itemDTO : dto.getOrderItems()) {
            final PedidoProdutoBO itemBO = new PedidoProdutoBO();

            final ProdutoBO produtoBO = new ProdutoBO();
            produtoBO.setId(itemDTO.getSku());
            itemBO.setProduto(produtoBO);

            itemBO.setQuantidade(itemDTO.getAmount());

            itens.add(itemBO);
        }
        pedidoBO.setItens(itens);

        return pedidoBO;
    }
}
