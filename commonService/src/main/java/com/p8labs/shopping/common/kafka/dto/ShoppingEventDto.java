package com.p8labs.shopping.common.kafka.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class ShoppingEventDto {
    private String eventName;
    private Long orderId;
    private Long userId;

    public ShoppingEventDto(String eventName,
                            Long orderId,
                            Long userId) {
        this.eventName = eventName;
        this.orderId = orderId;
        this.userId = userId;
    }

    public void updateEventName(String eventName) {
        this.eventName = eventName;
    }
}
