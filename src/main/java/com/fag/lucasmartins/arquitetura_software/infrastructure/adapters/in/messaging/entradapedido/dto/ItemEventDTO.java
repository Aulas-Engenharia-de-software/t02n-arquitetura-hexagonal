package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto;

public class ItemEventDTO {

    private Long sku;
    private Integer amount;
    
    public Long getSku() {
        return sku;
    }
    public void setSku(Long sku) {
        this.sku = sku;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
}
