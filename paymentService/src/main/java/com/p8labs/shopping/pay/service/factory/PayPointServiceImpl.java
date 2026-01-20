package com.p8labs.shopping.pay.service.factory;

import com.p8labs.shopping.pay.enums.PayType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PayPointServiceImpl extends PayCommonService {
    @Override
    public PayType getPayType() {
        return PayType.POINT;
    }

    @Override
    public boolean doProcess(Long userId, String desc, BigDecimal amount) {
        return true;
    }
}