package com.p8labs.shopping.pay.service;

import com.p8labs.shopping.pay.enums.PayType;
import com.p8labs.shopping.pay.service.factory.PayFactory;
import jakarta.transaction.NotSupportedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayOrchestrationService {
    private final PayFactory payFactory;

    public String pay(Long userId, String desc, BigDecimal amount) {
        try {
            PayService payService = payFactory.getPayService(PayType.CASH);
            return payService.executePayment(userId, desc, amount);
        } catch (Exception e) {
            return "";
        }
    }

    public String cancel(Long userId, Long orderId) {
        log.info("CANCEL PAY {} {} ", userId, orderId);
        return "";
    }
}