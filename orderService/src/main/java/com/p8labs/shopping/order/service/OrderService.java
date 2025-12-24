package com.p8labs.shopping.order.service;

import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.enums.OrderType;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface OrderService {
    Long save(Long userSeq, List<ProductDto> orderProducts);
    Long cancelOrder(Long userSeq, Long orderSeq);
    Long doneOrder(Long userSeq, Long orderSeq);
    Long updateOrderStatus(Long userSeq, Long orderSeq, OrderType orderType);
}