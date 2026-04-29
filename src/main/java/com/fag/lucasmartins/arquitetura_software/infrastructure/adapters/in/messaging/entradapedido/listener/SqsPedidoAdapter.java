package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.EntradaPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper.EntradaPedidoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.exceptions.ConsumerSQSException;
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

    @SqsListener(value = "${queue.order-events}")
    public void receberMensagem(EntradaPedidoDTO evento) {
        try {
            log.info("Evento de pedido recebido via SQS - origem: {}, ocorrido em: {}, cliente: {}",
                    evento.getOrigin(), evento.getOccurredAt(), evento.getCustomerId());

            final PedidoBO bo = EntradaPedidoDTOMapper.toBo(evento);
            final PedidoBO pedidoCriado = pedidoServicePort.criarPedido(bo);

            log.info("Pedido criado com sucesso via SQS - ID: {}, cliente: {}, valorTotal: {}",
                    pedidoCriado.getId(), evento.getCustomerId(), pedidoCriado.getValorTotal());
        } catch (Exception e) {
            log.error("Erro ao processar evento de pedido via SQS para o cliente {}",
                    evento.getCustomerId(), e);
            throw new ConsumerSQSException(
                    "Erro ao processar evento de pedido via SQS para o cliente " + evento.getCustomerId(), e);
        }
    }
}
