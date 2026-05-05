package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;

public class PedidoEventDTO {

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("customerId")
    private Integer customerId;

    @JsonProperty("orderItems")
    private List<OrderItemDTO> orderItems;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("occurredAt")
    private OffsetDateTime occurredAt;

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public List<OrderItemDTO> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItemDTO> orderItems) { this.orderItems = orderItems; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public OffsetDateTime getOccurredAt() { return occurredAt; }
    public void setOccurredAt(OffsetDateTime occurredAt) { this.occurredAt = occurredAt; }


    public static class OrderItemDTO {

        @JsonProperty("sku")
        private Integer sku;

        @JsonProperty("amount")
        private Integer amount;

        public Integer getSku() { return sku; }
        public void setSku(Integer sku) { this.sku = sku; }

        public Integer getAmount() { return amount; }
        public void setAmount(Integer amount) { this.amount = amount; }
    }
}