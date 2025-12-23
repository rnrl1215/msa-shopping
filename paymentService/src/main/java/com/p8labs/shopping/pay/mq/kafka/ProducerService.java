package com.p8labs.shopping.pay.mq.kafka;

import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, ShoppingEventDto> kafkaTemplate;

    public void sendMessage(String topic, ShoppingEventDto dto) {
        // 비동기 방식으로 메시지 전송
        kafkaTemplate.send(topic, dto);
        System.out.println("Sent message: " + dto + " to topic: " + topic);
    }
}
