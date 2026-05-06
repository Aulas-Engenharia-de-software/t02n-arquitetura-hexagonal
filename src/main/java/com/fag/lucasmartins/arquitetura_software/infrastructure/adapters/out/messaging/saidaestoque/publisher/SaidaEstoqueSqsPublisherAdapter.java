package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.messaging.saidaestoque.publisher;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.messaging.EstoqueEventPublisherPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.event.SaidaEstoqueEvent;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.messaging.saidaestoque.dto.SaidaEstoqueEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.messaging.saidaestoque.exceptions.PublisherSQSException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.messaging.saidaestoque.mapper.SaidaEstoqueDTOMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SaidaEstoqueSqsPublisherAdapter implements EstoqueEventPublisherPort {

    private static final Logger log = LoggerFactory.getLogger(SaidaEstoqueSqsPublisherAdapter.class);

    private final SqsTemplate sqsTemplate;

    @Value("${queue.saida-estoque}")
    private String filaSaidaEstoque;

    public SaidaEstoqueSqsPublisherAdapter(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    @Override
    public void publicarSaidaEstoque(SaidaEstoqueEvent evento) {
        try {
            final SaidaEstoqueEventDTO payload = SaidaEstoqueDTOMapper.toDto(evento);

            log.info("Publicando evento de saida de estoque para o produto {}", evento.getProdutoId());

            sqsTemplate.send(to -> to.queue(filaSaidaEstoque).payload(payload));

            log.info("Evento de saida de estoque publicado para o produto {}", evento.getProdutoId());
        } catch (Exception e) {
            log.error("Erro ao publicar evento de saida de estoque para o produto {}", evento.getProdutoId(), e);
            throw new PublisherSQSException(
                    "Erro ao publicar evento de saida de estoque para o produto " + evento.getProdutoId(), e);
        }
    }
}
