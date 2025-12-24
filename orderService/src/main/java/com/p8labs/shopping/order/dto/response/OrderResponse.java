package com.p8labs.shopping.order.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderResponse {
    private final Long orderId;

    public OrderResponse(Long orderId) {
        this.orderId = orderId;
    }
}
