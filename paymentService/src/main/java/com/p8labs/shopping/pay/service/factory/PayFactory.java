package com.p8labs.shopping.pay.service.factory;

import com.p8labs.shopping.pay.enums.PayType;
import com.p8labs.shopping.pay.service.PayService;
import jakarta.transaction.NotSupportedException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component
public class PayFactory {
    private final Map<PayType, PayService> payServiceMap = new HashMap<>();

    public PayFactory(List<PayService> payServices) {
        for (PayService o : payServices) {
            payServiceMap.put(o.getPayType(), o);
        }
    }

    public PayService getPayService(PayType payType) throws NotSupportedException {
        PayService findService = payServiceMap.getOrDefault(payType, null);
        if (findService == null) {
            throw new NotSupportedException("지원 되지 않는 타입 입니다.".concat(payType.name()));
        }
        return findService;
    }
}
