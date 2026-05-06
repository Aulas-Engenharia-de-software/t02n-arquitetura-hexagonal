package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.dto.SQSPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.mapper.SQSPedidoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.exceptions.ConsumerSQSException;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SQSPedidoAdapter {

    private static final Logger log = LoggerFactory.getLogger(SQSPedidoAdapter.class);

    private final PedidoServicePort pedidoServicePort;

    public SQSPedidoAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener("${queue.order-events}")
    public void listen(SQSPedidoDTO dto) {
        try {
            log.info("Mensagem recebida do cliente {}", dto.getCustomerId());

            final PedidoBO bo = SQSPedidoDTOMapper.toBo(dto);
            pedidoServicePort.criarPedido(bo);

            log.info("Mensagem consumida com sucesso para o cliente {}", dto.getCustomerId());
        } catch (Exception e) {
            log.error("Erro ao processar pedido do SQS para o cliente {}", dto.getCustomerId(), e);
            throw new ConsumerSQSException(
                    "Erro ao processar pedido do SQS para o cliente " + dto.getCustomerId(), e);
        }
    }
}
