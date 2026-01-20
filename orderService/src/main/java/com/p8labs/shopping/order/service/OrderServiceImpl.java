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
    public Long save(Long userId, List<ProductDto> orderProducts) {
        if (Math.random() < 0.5) {
            throw new IllegalArgumentException("주문 저장 실패");
        }
        return 1L;
    }

    @Transactional
    @Override
    public Long cancelOrder(Long userId, Long orderId) {
        if (userId == null || orderId == null) {
            throw new IllegalArgumentException("주문 취소 실패");
        }

        updateOrderStatus(userId, orderId, OrderType.CANCEL);
        log.info("ORDER CANCEL userId: {} orderId: {}", userId, orderId);
        return orderId;
    }

    @Transactional
    @Override
    public Long doneOrder(Long userId, Long orderId) {
        if (userId == null || orderId == null) {
            throw new IllegalArgumentException("주문 취소 실패");
        }

        updateOrderStatus(userId, orderId, OrderType.DONE);
        log.info("ORDER SUCCESS userId: {} orderId: {}", userId, orderId);
        return orderId;
    }

    @Transactional
    public Long updateOrderStatus(Long userId, Long orderId, OrderType orderType) {
        log.info("ORDER UPDATE userId: {} orderId: {} orderType: {}", userId, orderId, orderType);
        return orderId;
    }
}