package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.listener;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.PedidoSqsDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper.PedidoSqsDTOMapper;

import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class SqsPedidoAdapter {

    private final PedidoServicePort pedidoServicePort;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener(value= "${queue.order-events}")
    public void listen(PedidoSqsDTO dto) {
        System.out.println("Mensagem recebida: " + dto.getCustomerId());

        PedidoBO bo = PedidoSqsDTOMapper.toBo(dto);

        pedidoServicePort.criarPedido(bo);

        System.out.println("Mensagem consumida com sucesso");
    }
}
