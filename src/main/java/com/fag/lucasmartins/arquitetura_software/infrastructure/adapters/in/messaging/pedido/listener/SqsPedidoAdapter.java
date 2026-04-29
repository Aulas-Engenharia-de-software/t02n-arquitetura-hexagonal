package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.exceptions.ConsumerSQSException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.SqsPedidoEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.SqsPedidoMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SqsPedidoAdapter {

    private static final Logger log = LoggerFactory.getLogger(SqsPedidoAdapter.class);

    private final PedidoServicePort pedidoServicePort;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener(value = "${aws.sqs.queue.pedido}")
    public void receberPedido(SqsPedidoEventDTO evento) {
        try {
            log.info("Evento de pedido recebido via SQS para o cliente {}", evento.getCustomerId());

            final PedidoBO pedidoBO = SqsPedidoMapper.toBo(evento);

            pedidoServicePort.criarPedido(pedidoBO);

            log.info("Pedido processado com sucesso para o cliente {}", evento.getCustomerId());
        } catch (Exception e) {
            log.error("Erro ao processar o pedido do SQS para o cliente {}", evento.getCustomerId(), e);
            throw new ConsumerSQSException("Erro ao processar o pedido do cliente " + evento.getCustomerId(), e);
        }
    }
}