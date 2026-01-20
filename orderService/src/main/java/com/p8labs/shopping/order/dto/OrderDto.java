package com.p8labs.shopping.order.dto;

import lombok.Getter;
import java.util.*;

@Getter
public class OrderDto {
    private Long id;
    private final Long userId;
    private final List<ProductDto> orderProducts;

    public OrderDto(Long userId, List<ProductDto> orderProducts) {
        this.userId = userId;
        this.orderProducts = orderProducts;
    }
}