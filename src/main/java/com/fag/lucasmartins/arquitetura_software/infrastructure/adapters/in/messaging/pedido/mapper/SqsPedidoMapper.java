package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.SqsPedidoEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.SqsPedidoItemDTO;

import java.util.ArrayList;
import java.util.List;

public class SqsPedidoMapper {

    public static PedidoBO toBo(SqsPedidoEventDTO dto) {
        PedidoBO pedidoBO = new PedidoBO();
        
        pedidoBO.setCep(dto.getZipCode()); 
        
        PessoaBO pessoa = new PessoaBO();
        pessoa.setId(dto.getCustomerId());
        pedidoBO.setPessoa(pessoa);

        List<PedidoProdutoBO> itensBO = new ArrayList<>();
        if (dto.getOrderItems() != null) {
            for (SqsPedidoItemDTO itemDTO : dto.getOrderItems()) {
                PedidoProdutoBO itemBO = new PedidoProdutoBO();
                itemBO.setQuantidade(itemDTO.getAmount());
                
                ProdutoBO produto = new ProdutoBO();
                produto.setId(itemDTO.getSku());
                itemBO.setProduto(produto);
                
                itensBO.add(itemBO);
            }
        }
        pedidoBO.setItens(itensBO);
        
        return pedidoBO;
    }
}