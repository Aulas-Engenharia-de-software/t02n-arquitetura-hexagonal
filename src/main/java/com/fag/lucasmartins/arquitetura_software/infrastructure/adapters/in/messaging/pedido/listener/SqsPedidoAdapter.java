package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.EventoPedidoSqsDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.EventoPedidoSqsMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsPedidoAdapter {

    private final PedidoServicePort pedidoServicePort;
    private final EventoPedidoSqsMapper mapper;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort, EventoPedidoSqsMapper mapper) {
        this.pedidoServicePort = pedidoServicePort;
        this.mapper = mapper;
    }

    @SqsListener("${queue.order-events}")
    public void listen(EventoPedidoSqsDTO dto) {
        System.out.println("Mensagem recebida com sucesso para o cliente ID: " + dto.getCustomerId());

        PedidoBO criado = process(dto);

        System.out.println("Pedido criado com sucesso no sistema. ID do pedido: " + criado.getId());
    }

    private PedidoBO process(EventoPedidoSqsDTO dto) {
        PedidoBO pedidoBO = mapper.toBO(dto);
        return pedidoServicePort.criarPedido(pedidoBO);
    }
}