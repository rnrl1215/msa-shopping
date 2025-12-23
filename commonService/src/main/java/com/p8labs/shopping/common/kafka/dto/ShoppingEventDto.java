package com.p8labs.shopping.common.kafka.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
