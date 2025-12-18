package com.p8labs.shopping.common.kafka.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ShoppingEventDto {
    private String eventName;
    private Long orderId;

    public ShoppingEventDto(String eventName, Long orderId) {
        this.eventName = eventName;
        this.orderId = orderId;
    }
}
