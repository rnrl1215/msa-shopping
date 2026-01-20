package com.p8labs.shopping.order.dto;

import lombok.Getter;

@Getter
public class ProductDto {
    private Long id;
    private Long userId;
    private Long productId;
    private int orderCount;

    public ProductDto(Long userId, Long productId, int orderCount) {
        this.userId = userId;
        this.productId = productId;
        this.orderCount = orderCount;
    }
}