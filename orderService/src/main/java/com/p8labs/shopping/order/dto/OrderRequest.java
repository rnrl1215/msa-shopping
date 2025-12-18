package com.p8labs.shopping.order.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequest {
    private final Long userSeq;
    private final List<Long> productIds;

    public OrderRequest(Long userSeq, List<Long> productIds) {
        this.userSeq = userSeq;
        this.productIds = productIds;
    }
}
