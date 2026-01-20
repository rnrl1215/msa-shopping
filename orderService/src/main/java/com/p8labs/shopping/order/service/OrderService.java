package com.p8labs.shopping.order.service;

import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.enums.OrderType;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface OrderService {
    Long save(Long userId, List<ProductDto> orderProducts);
    Long cancelOrder(Long userId, Long orderId);
    Long doneOrder(Long userId, Long orderId);
    Long updateOrderStatus(Long userId, Long orderId, OrderType orderType);
}