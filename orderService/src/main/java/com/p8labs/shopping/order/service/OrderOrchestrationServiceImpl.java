package com.p8labs.shopping.order.service;

import com.p8labs.shopping.common.exception.CommonServiceException;
import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.enums.OrderExceptionEnum;
import com.p8labs.shopping.order.mq.kafka.ProducerService;
import com.querydsl.core.util.CollectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Primary
@Service
public class OrderOrchestrationServiceImpl {

    private final OrderService orderService;
    private final ProducerService producerService;

    public Long createOrder(Long userSeq, List<Long> productIds) {
        try {
            List<ProductDto> findProducts = findProducts(productIds);
            Long orderId = orderService.save(userSeq, findProducts);

            ShoppingEventDto dto = new ShoppingEventDto("ORDER_CREATED", orderId);
            producerService.sendMessage("order-event-process", dto);
            return orderId;
        } catch (Exception e) {
            throw new CommonServiceException(OrderExceptionEnum.ORDER_REQUEST_FAIL, e.getMessage());
        }
    }

    public List<ProductDto> findProducts(List<Long> productIds) {
        return Collections.EMPTY_LIST;
    }
}