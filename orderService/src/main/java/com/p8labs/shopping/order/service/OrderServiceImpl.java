package com.p8labs.shopping.order.service;

import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.enums.OrderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Transactional
    @Override
    public Long save(Long userSeq, List<ProductDto> orderProducts) {
        if (Math.random() < 0.5) {
            throw new IllegalArgumentException("주문 저장 실패");
        }
        return 1L;
    }

    @Transactional
    @Override
    public Long cancelOrder(Long userSeq, Long orderSeq) {
        if (userSeq == null || orderSeq == null) {
            throw new IllegalArgumentException("주문 취소 실패");
        }

        updateOrderStatus(userSeq, orderSeq, OrderType.CANCEL);
        log.info("ORDER CANCEL userSeq: {} orderSeq: {}", userSeq, orderSeq);
        return orderSeq;
    }

    @Transactional
    @Override
    public Long doneOrder(Long userSeq, Long orderSeq) {
        if (userSeq == null || orderSeq == null) {
            throw new IllegalArgumentException("주문 취소 실패");
        }

        updateOrderStatus(userSeq, orderSeq, OrderType.DONE);
        log.info("ORDER SUCCESS userSeq: {} orderSeq: {}", userSeq, orderSeq);
        return orderSeq;
    }

    @Transactional
    public Long updateOrderStatus(Long userSeq, Long orderSeq, OrderType orderType) {
        log.info("ORDER UPDATE userSeq: {} orderSeq: {} orderType: {}", userSeq, orderSeq, orderType);
        return orderSeq;
    }
}