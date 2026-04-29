package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaPedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.ProdutoRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaPedido.dto.EntradaPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaPedido.mapper.EntradaPedidoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.exceptions.ConsumerSQSException;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EntradaPedidoSqsAdapter {
    private static final Logger log = LoggerFactory.getLogger(EntradaPedidoSqsAdapter.class);
    
    private final PedidoServicePort pedidoServicePort;
    private final EntradaPedidoDTOMapper mapper;

    public EntradaPedidoSqsAdapter(
            PedidoServicePort pedidoServicePort,
            PessoaRepositoryPort pessoaRepositoryPort,
            ProdutoRepositoryPort produtoRepositoryPort) {
        this.pedidoServicePort = pedidoServicePort;
        this.mapper = new EntradaPedidoDTOMapper(pessoaRepositoryPort, produtoRepositoryPort);
    }

    @SqsListener(value = "${aws.sqs.queue.entrada-pedido}")
    public void receberMensagem(EntradaPedidoDTO evento) {
        try {
            log.info("Evento de pedido recebido para o cliente {}", evento.getCustomerId());
            
            final PedidoBO bo = mapper.toBo(evento);
            
            final PedidoBO pedidoCriado = pedidoServicePort.criarPedido(bo);
            
            log.info("Pedido criado com sucesso! ID: {}, Cliente: {}", 
                    pedidoCriado.getId(), evento.getCustomerId());
        } catch (Exception e) {
            log.error("Erro ao processar o evento de pedido para o cliente {}", evento.getCustomerId(), e);
            throw new ConsumerSQSException(
                    "erro ao processar o evento de pedido para o cliente " + evento.getCustomerId(), e);
        }
    }
}