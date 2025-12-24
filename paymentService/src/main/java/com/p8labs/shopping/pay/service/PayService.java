package com.p8labs.shopping.pay.service;

import com.p8labs.shopping.pay.enums.PayType;

import java.math.BigDecimal;

public interface PayService {
    PayType getPayType();
    String executePayment(Long userSeq, String desc, BigDecimal bigDecimal);
}