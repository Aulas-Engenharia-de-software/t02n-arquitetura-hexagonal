package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.dto;

import java.util.List;

public class SQSPedidoDTO {
    private String zipCode;

    private Integer customerId;

    private List<SQSPedidoProdutoDTO> orderItems;

    private String origin;

    private String occurredAt;

    public SQSPedidoDTO() {
    }

    public SQSPedidoDTO(String zipCode, Integer customerId, List<SQSPedidoProdutoDTO> orderItems, String origin, String occurredAt) {
        this.zipCode = zipCode;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.origin = origin;
        this.occurredAt = occurredAt;
    }

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

    public List<SQSPedidoProdutoDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<SQSPedidoProdutoDTO> orderItems) {
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
