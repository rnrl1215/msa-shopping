package com.p8labs.shopping.order.mq.kafka;

import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "order-event-process", groupId = "order-event-process-id")
    public void consume(ShoppingEventDto dto) {
        System.out.println("주문 서비스 수신된 메시지: " + dto);
    }


    @KafkaListener(topics = "payment-event-topic", groupId = "order-event-process-id")
    public void consumeOfPayEvent(ShoppingEventDto dto) {
        System.out.println("주문 서비스 수신된 메시지: " + dto);
    }
}
