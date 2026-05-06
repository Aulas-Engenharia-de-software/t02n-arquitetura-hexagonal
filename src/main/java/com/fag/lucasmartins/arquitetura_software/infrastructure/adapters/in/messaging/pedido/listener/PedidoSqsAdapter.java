package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.exceptions.ConsumerSQSException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.PedidoEventDTOMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PedidoSqsAdapter {

    private static final Logger log = LoggerFactory.getLogger(PedidoSqsAdapter.class);

    private final PedidoServicePort pedidoServicePort;

    public PedidoSqsAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener("${queue.order-events}")
    public void receberMensagem(PedidoEventDTO evento) {
        try {
            log.info("[SQS] Evento de pedido recebido — customerId={}, zipCode={}, origem={}, ocorridoEm={}",
                    evento.getCustomerId(),
                    evento.getZipCode(),
                    evento.getOrigin(),
                    evento.getOccurredAt());

            final PedidoBO pedidoBO = PedidoEventDTOMapper.toBo(evento);
            final PedidoBO pedidoSalvo = pedidoServicePort.criarPedido(pedidoBO);

            log.info("[SQS] Pedido processado e persistido com sucesso — id={}, customerId={}, valorTotal={}",
                    pedidoSalvo.getId(),
                    evento.getCustomerId(),
                    pedidoSalvo.getValorTotal());

        } catch (Exception e) {
            log.error("[SQS] Falha ao processar evento de pedido — customerId={}", evento.getCustomerId(), e);
            throw new ConsumerSQSException(
                    "Erro ao processar pedido do cliente " + evento.getCustomerId(), e
            );
        }
    }
}