package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventDTO;

public class PedidoDTOMapper {
    public static PedidoBO toBO(PedidoEventDTO dto) {
        PedidoBO bo = new PedidoBO();
        PessoaBO pessoaBO = new PessoaBO();
        List<PedidoProdutoBO> items = new ArrayList<>();

        pessoaBO.setId(dto.getCustomerId());

        dto.getOrderItems().forEach(i -> {
            ProdutoBO produto = new ProdutoBO();

            produto.setId(i.getSku());
            
            PedidoProdutoBO pedidoProduto = new PedidoProdutoBO();
            pedidoProduto.setQuantidade(i.getAmount());
            pedidoProduto.setProduto(produto);
            
            items.add(pedidoProduto);
        });

        bo.setCep(dto.getZipCode());
        bo.setItens(items);
        bo.setPessoa(pessoaBO);        

        return bo;
    }
}
