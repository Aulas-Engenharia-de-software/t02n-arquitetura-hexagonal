package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import io.awspring.cloud.sqs.annotation.SqsListener;


import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.PedidoEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper.PedidoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.exceptions.ConsumerSQSException;

@Component
public class SqsPedidoAdapter {

    private static final Logger log = LoggerFactory.getLogger(SqsPedidoAdapter.class);

    private final PedidoServicePort pedidoServicePort;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener(value = "${queue.order-events}")
    public void receberMensagem(PedidoEventDTO evento) {
        try {
            log.info("Evento de pedido recebido para o cliente {}", evento.getCustomerId());

            final PedidoBO bo = PedidoDTOMapper.toBo(evento);

            pedidoServicePort.criarPedido(bo);

            log.info("Pedido processado com sucesso para o cliente {}", evento.getCustomerId());

        } catch (Exception e) {
            log.error("Erro ao processar pedido do cliente {}", evento != null ? evento.getCustomerId() : "null", e);
            throw new ConsumerSQSException("Erro ao processar pedido", e);
        }
    }
}