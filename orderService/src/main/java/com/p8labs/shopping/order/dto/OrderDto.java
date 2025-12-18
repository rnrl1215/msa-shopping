package com.p8labs.shopping.order.dto;

import lombok.Getter;
import java.util.*;

@Getter
public class OrderDto {
    private Long id;
    private final Long userSeq;
    private final List<ProductDto> orderProducts;

    public OrderDto(Long userSeq, List<ProductDto> orderProducts) {
        this.userSeq = userSeq;
        this.orderProducts = orderProducts;
    }
}