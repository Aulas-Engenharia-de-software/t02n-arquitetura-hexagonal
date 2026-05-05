package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.PedidoEventDTO;

public class PedidoDTOMapper {

    public static PedidoBO toBo(PedidoEventDTO dto) {

        List<PedidoProdutoBO> itens = dto.getOrderItems()
                .stream()
                .map(item -> {

                    PedidoProdutoBO pedidoProduto = new PedidoProdutoBO();

                    ProdutoBO produto = new ProdutoBO();

                    if (item.getSku() != null) {
                        produto.setId(item.getSku().intValue());
                    }

                    pedidoProduto.setProduto(produto);
                    pedidoProduto.setQuantidade(item.getAmount());

                    return pedidoProduto;
                })
                .collect(Collectors.toList());

        PedidoBO pedido = new PedidoBO();

        pedido.setCep(dto.getZipCode());

        PessoaBO pessoa = new PessoaBO();

        if (dto.getCustomerId() != null) {
            pessoa.setId(dto.getCustomerId().intValue());
        }

        pedido.setPessoa(pessoa);

        pedido.setItens(itens);

        return pedido;
    }
}