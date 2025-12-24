package com.p8labs.shopping.order.service;

import com.p8labs.shopping.common.exception.CommonServiceException;
import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import com.p8labs.shopping.common.kafka.dto.ShoppingPayEventDto;
import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.enums.OrderExceptionEnum;
import com.p8labs.shopping.order.enums.OrderType;
import com.p8labs.shopping.order.mq.kafka.ProducerService;
import com.querydsl.core.util.CollectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderOrchestrationServiceImpl {

    private final OrderService orderService;
    private final ProducerService producerService;

    public Long createOrder(Long userSeq, List<Long> productIds) {
        try {
            List<ProductDto> findProducts = findProducts(productIds);
            Long orderId = orderService.save(userSeq, findProducts);

            ShoppingEventDto dto = new ShoppingPayEventDto("ORDER_CREATED", orderId, userSeq, "상품 결재", BigDecimal.TEN);
            producerService.sendMessage("payment-event-topic", dto);
            return orderId;
        } catch (Exception e) {
            throw new CommonServiceException(OrderExceptionEnum.ORDER_REQUEST_FAIL, e.getMessage());
        }
    }

    public List<ProductDto> findProducts(List<Long> productIds) {
        return Collections.EMPTY_LIST;
    }

    public void cancelOrder(Long userSeq, Long orderSeq) {
        orderService.updateOrderStatus(userSeq, orderSeq, OrderType.CANCEL);
    }

    public void successOrder(Long userSeq, Long orderSeq) {
        orderService.updateOrderStatus(userSeq, orderSeq, OrderType.DONE);
    }
}