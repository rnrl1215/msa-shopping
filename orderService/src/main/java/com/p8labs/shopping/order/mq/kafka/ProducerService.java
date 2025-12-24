package com.p8labs.shopping.order.mq.kafka;

import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, ShoppingEventDto> kafkaTemplate;

    public void sendMessage(String topic, ShoppingEventDto dto) {
        // 비동기 방식으로 메시지 전송
        kafkaTemplate.send(topic, dto);
        log.info("Sent message: {} to topic: {}", dto, topic);
    }
}
