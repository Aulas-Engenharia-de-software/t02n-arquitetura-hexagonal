package com.fag.lucasmartins.arquitetura_software.application.ports.out.messaging;

import com.fag.lucasmartins.arquitetura_software.core.domain.event.SaidaEstoqueEvent;

/**
 * Porta de saída (driven port) para publicação de eventos de estoque.
 * A aplicação chama essa porta; quem implementa está no pacote
 * infrastructure/adapters/out/messaging.
 */
public interface EstoqueEventPublisherPort {

    void publicarSaidaEstoque(SaidaEstoqueEvent evento);
}
