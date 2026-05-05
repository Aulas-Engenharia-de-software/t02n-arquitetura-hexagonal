package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto;

import java.time.Instant;
import java.util.List;

public class PedidoEventDTO {

    private String zipCode;
    private Long customerId;
    private List<ItemEventDTO> orderItems;
    private String origin;
    private String occurredAt;


    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public List<ItemEventDTO> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<ItemEventDTO> orderItems) {
        this.orderItems = orderItems;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getOccurredAt() {
        return occurredAt;
    }
    public void setOccurredAt(String occurredAt) {
        this.occurredAt = occurredAt;
    }
    
}


