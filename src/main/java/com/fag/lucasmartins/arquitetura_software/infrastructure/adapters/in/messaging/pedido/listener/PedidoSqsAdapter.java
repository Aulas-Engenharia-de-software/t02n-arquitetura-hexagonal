package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.PedidoDTOMapper;

import io.awspring.cloud.sqs.annotation.SqsListener;
@Component
public class PedidoSqsAdapter {
    
    private final PedidoServicePort pedidoServicePort;

    public PedidoSqsAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener(value="${queue.order-events}")
    public void listen(PedidoEventDTO dto) {
        System.out.println("Mensagem recebida" + dto.getCustomerId());
        PedidoBO bo = PedidoDTOMapper.toBO(dto);

        pedidoServicePort.criarPedido(bo);

        System.out.println("Mensagem consumida com sucesso!");
    } 
}
 