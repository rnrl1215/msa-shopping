package com.p8labs.shopping.pay.service.factory;

import com.p8labs.shopping.pay.enums.PayType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PayCashServiceImpl extends PayCommonService {

    @Override
    public PayType getPayType() {
        return PayType.CASH;
    }

    @Override
    public boolean doProcess(Long userId, String desc, BigDecimal bigDecimal) {
        return false;
    }
}