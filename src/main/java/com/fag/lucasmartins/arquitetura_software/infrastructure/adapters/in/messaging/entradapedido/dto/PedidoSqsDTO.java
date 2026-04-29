package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto;

import java.util.ArrayList;

public class PedidoSqsDTO {
    private String zipCode;
    private Integer customerId;
    private ArrayList<PedidoItemSqsDTO> orderItems;

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
    public ArrayList<PedidoItemSqsDTO> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(ArrayList<PedidoItemSqsDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
