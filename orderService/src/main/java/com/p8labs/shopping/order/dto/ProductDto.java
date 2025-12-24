package com.p8labs.shopping.order.dto;

import lombok.Getter;

@Getter
public class ProductDto {
    private Long id;
    private Long userSeq;
    private Long productId;
    private int orderCount;

    public ProductDto(Long userSeq, Long productId, int orderCount) {
        this.userSeq = userSeq;
        this.productId = productId;
        this.orderCount = orderCount;
    }
}