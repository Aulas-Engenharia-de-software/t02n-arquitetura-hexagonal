package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.PedidoSqsDTO;

public class PedidoSqsDTOMapper {
    
    public static PedidoBO toBo (PedidoSqsDTO dto) {
        PedidoBO pedidoBO = new PedidoBO();
        PessoaBO pessoaBO = new PessoaBO();
        List<PedidoProdutoBO> items = new ArrayList<>();

        dto.getOrderItems().forEach(i -> {
            ProdutoBO produtoBO = new ProdutoBO();

            produtoBO.setId(i.getSku());

            PedidoProdutoBO pedidoProdutoBO = new PedidoProdutoBO();
            pedidoProdutoBO.setQuantidade(i.getAmount());
            pedidoProdutoBO.setProduto(produtoBO);

            items.add(pedidoProdutoBO);
        });

        pessoaBO.setId(dto.getCustomerId());

        pedidoBO.setCep(dto.getZipCode());
        pedidoBO.setPessoa(pessoaBO);
        pedidoBO.setItens(items);

        return pedidoBO;
    }
}
