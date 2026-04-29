package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SqsPedidoEventDTO {

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("customerId")
    private Integer customerId;

    @JsonProperty("orderItems")
    private List<SqsPedidoItemDTO> orderItems;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("occurredAt")
    private String occurredAt;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<SqsPedidoItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<SqsPedidoItemDTO> orderItems) {
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