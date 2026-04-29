package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SqsPedidoItemDTO {
    
    @JsonProperty("sku")
    private Integer sku;

    @JsonProperty("amount")
    private Integer amount;

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
