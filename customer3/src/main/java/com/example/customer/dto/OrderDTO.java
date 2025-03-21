package com.example.customer.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private String orderId;
    private Integer customerId;
    private List<OrderPositionDTO> orderPositions = new ArrayList<>();

    public OrderDTO() {}

    public OrderDTO(Integer customerId) {
        this.customerId = customerId;
    }

    public OrderDTO(String orderId, Integer customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderPositions = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<OrderPositionDTO> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPositionDTO> orderPositions) {
        this.orderPositions = orderPositions;
    }
}
