package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.dto.SQSPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.dto.SQSPedidoProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class SQSPedidoDTOMapper {

    private SQSPedidoDTOMapper() {
    }

    public static PedidoBO toBo(SQSPedidoDTO sqsPedidoDTO) {
        final PedidoBO pedidoBO = new PedidoBO();
        final PessoaBO pessoaBO = new PessoaBO();

        pessoaBO.setId(sqsPedidoDTO.getCustomerId());
        pedidoBO.setCep(sqsPedidoDTO.getZipCode());
        pedidoBO.setPessoa(pessoaBO);

        final List<PedidoProdutoBO> itens = new ArrayList<>();
        if (sqsPedidoDTO.getOrderItems() != null) {
            for (SQSPedidoProdutoDTO itemDTO : sqsPedidoDTO.getOrderItems()) {
                itens.add(SQSPedidoProdutoDTOMapper.toBo(itemDTO));
            }
        }
        pedidoBO.setItens(itens);

        return pedidoBO;
    }
}
