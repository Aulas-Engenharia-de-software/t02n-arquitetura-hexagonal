package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaPedido.mapper;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.ProdutoRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaPedido.dto.EntradaPedidoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EntradaPedidoDTOMapper {

    private final PessoaRepositoryPort pessoaRepositoryPort;
    private final ProdutoRepositoryPort produtoRepositoryPort;

    public EntradaPedidoDTOMapper(PessoaRepositoryPort pessoaRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort) {
        this.pessoaRepositoryPort = pessoaRepositoryPort;
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    public PedidoBO toBo(EntradaPedidoDTO dto) {
        // Buscar pessoa pelo customerId
        PessoaBO pessoaBO = pessoaRepositoryPort.encontrarPorId(dto.getCustomerId());

        // Mapear itens buscando produto pelo SKU
        List<PedidoProdutoBO> itens = dto.getOrderItems().stream()
            .map(item -> {
                PedidoProdutoBO pedidoItem = new PedidoProdutoBO();
                pedidoItem.setQuantidade(item.getAmount());
                pedidoItem.setProduto(produtoRepositoryPort.encontrarPorId(item.getSku()));
                return pedidoItem;
            })
            .collect(Collectors.toList());

        // Montar o pedido
        PedidoBO pedidoBO = new PedidoBO();
        pedidoBO.setCep(dto.getZipCode());
        pedidoBO.setPessoa(pessoaBO);
        pedidoBO.setItens(itens);

        return pedidoBO;
    }
}