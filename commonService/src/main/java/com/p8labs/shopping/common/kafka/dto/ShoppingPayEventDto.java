package com.p8labs.shopping.common.kafka.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ShoppingPayEventDto extends ShoppingEventDto {
    private String paymentDesc;
    private BigDecimal orderAmount;
    private String payTrId;

    public ShoppingPayEventDto(String eventName,
                               Long orderId,
                               Long userId,
                               String paymentDesc,
                               BigDecimal orderAmount)
    {
        super(eventName, orderId, userId);
        this.paymentDesc = paymentDesc;
        this.orderAmount = orderAmount;
        this.payTrId = payTrId;
    }

    public void updatePayTrId(String payTrId) {
        this.payTrId = payTrId;
    }
}
