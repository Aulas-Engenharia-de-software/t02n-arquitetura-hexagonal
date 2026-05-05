package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.dto;

public class SQSPedidoProdutoDTO {

    private Integer sku;

    private Integer amount;

    public SQSPedidoProdutoDTO() {
    }

    public SQSPedidoProdutoDTO(Integer sku, Integer amount) {
        this.sku = sku;
        this.amount = amount;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
