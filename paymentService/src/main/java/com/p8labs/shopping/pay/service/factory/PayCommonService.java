package com.p8labs.shopping.pay.service.factory;

import com.p8labs.shopping.pay.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Service
public abstract class PayCommonService implements PayService {

    @Override
    public String executePayment(Long userId, String desc, BigDecimal bigDecimal) {
        log.info("결제 시작 PAY TYPE: {} userId: {} desc: {}", getPayType(), userId,  desc);
        doProcess(userId, desc, bigDecimal);
        log.info("결제 종료");
        return UUID.randomUUID().toString();
    }

    public abstract boolean doProcess(Long userId, String desc, BigDecimal amount);
}