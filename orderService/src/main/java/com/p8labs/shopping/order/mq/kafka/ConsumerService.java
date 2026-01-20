package com.p8labs.shopping.order.mq.kafka;

import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import com.p8labs.shopping.order.service.OrderOrchestrationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final OrderOrchestrationServiceImpl orderOrchestrationService;

    @KafkaListener(topics = "order-event-topic", groupId = "order-event-process")
    public void consume(ShoppingEventDto dto) {
        log.info("주문 서비스 수신된 메시지: {}", dto);
        if ("PAYMENT_COMPLETED".equalsIgnoreCase(dto.getEventName())) {
            orderOrchestrationService.successOrder(dto.getUserId(), dto.getOrderId());
        } else if("PAYMENT_FAILED".equalsIgnoreCase(dto.getEventName())) {
            orderOrchestrationService.cancelOrder(dto.getUserId(), dto.getOrderId());
        } else if ("SHIPMENT_REQUEST".equalsIgnoreCase(dto.getEventName())) {
            orderOrchestrationService.successRequestShipping(dto.getUserId(), dto.getOrderId());
        }
    }
}