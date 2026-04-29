package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsPedidoAdapter {

    private final PedidoServicePort pedidoServicePort;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener("${queue.order-events}")
    public void listen(PedidoEventDTO dto) {

        System.out.println("Mensagem recebida: " + dto.getCustomerId());

        // sem alterar código antigo
        // só prova que recebeu

        System.out.println("Mensagem consumida com sucesso.");
    }
}