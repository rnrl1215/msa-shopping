package com.p8labs.shopping.common.kafka.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ShippingEventDto extends ShoppingEventDto {
    private String shippingTrId;

    public ShippingEventDto(String eventName,
                            Long orderId,
                            Long userId,
                            String shippingTrId)
    {
        super(eventName, orderId, userId);
        this.shippingTrId = shippingTrId;
    }

    public void updatePayTrId(String shippingTrId) {
        this.shippingTrId = shippingTrId;
    }
}