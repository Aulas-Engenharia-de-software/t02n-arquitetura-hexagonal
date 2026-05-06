package com.fag.lucasmartins.arquitetura_software.core.domain.event;

/**
 * Evento de domínio: o estoque de um produto foi diminuído como
 * consequência da criação de um pedido. Publicado para que outros
 * sistemas (BI, fulfillment, etc.) possam reagir.
 */
public class SaidaEstoqueEvent {

    private final Integer produtoId;

    private final Integer quantidade;

    public SaidaEstoqueEvent(Integer produtoId, Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
