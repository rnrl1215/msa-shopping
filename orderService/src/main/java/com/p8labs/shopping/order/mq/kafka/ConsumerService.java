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
        if (dto.getEventName().equalsIgnoreCase("PAYMENT_COMPLETED")) {
            orderOrchestrationService.successOrder(dto.getUserSeq(), dto.getOrderSeq());
        } else {
            orderOrchestrationService.cancelOrder(dto.getUserSeq(), dto.getOrderSeq());
        }
    }
}
