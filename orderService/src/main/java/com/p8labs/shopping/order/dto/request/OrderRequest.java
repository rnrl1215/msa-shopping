package com.p8labs.shopping.order.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequest {
    private final Long userId;
    private final List<Long> productIds;

    public OrderRequest(Long userId, List<Long> productIds) {
        this.userId = userId;
        this.productIds = productIds;
    }
}
