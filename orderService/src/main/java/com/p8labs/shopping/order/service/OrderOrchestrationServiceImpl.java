package com.p8labs.shopping.order.service;

import com.p8labs.shopping.common.exception.CommonServiceException;
import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.enums.OrderExceptionEnum;
import com.p8labs.shopping.order.mq.kafka.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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
            if (orderId != null) {
                throw new IllegalArgumentException("tsete");
            }

            ShoppingEventDto dto = new ShoppingEventDto("ORDER", orderId);
            producerService.sendMessage("order-event-process", dto);
            return orderId;
        } catch (Exception e) {
            throw new CommonServiceException(OrderExceptionEnum.ORDER_REQUEST_FAIL);
        }
    }

    public List<ProductDto> findProducts(List<Long> productIds) {
        return null;
    }
}