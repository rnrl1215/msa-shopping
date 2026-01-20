package com.p8labs.shopping.pay.mq.kafka;

import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import com.p8labs.shopping.common.kafka.dto.ShoppingPayEventDto;
import com.p8labs.shopping.pay.service.PayOrchestrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConsumerService {

    private final PayOrchestrationService payOrchestrationService;
    private final ProducerService producerService;

    @KafkaListener(topics = "payment-event-topic", groupId = "pay-event-process")
    public void consumeOfPayEvent(ShoppingEventDto dto) {

        log.info("페이 서비스 수신된 메시지: {}", dto);
        try {
            if (dto instanceof ShoppingPayEventDto shoppingEventDto) {
                String payTrId = payOrchestrationService.pay(
                        shoppingEventDto.getUserId(),
                        shoppingEventDto.getPaymentDesc(),
                        shoppingEventDto.getOrderAmount());
                shoppingEventDto.updatePayTrId(payTrId);

                if (StringUtils.hasText(shoppingEventDto.getPayTrId())) {
                    dto.updateEventName("PAYMENT_COMPLETED");
                    producerService.sendMessage("order-event-topic", dto);
                } else {
                    throw new IllegalArgumentException("결제 실패");
                }
            }
        } catch (Exception e) {
            log.error("결제 실패: {}", e.getMessage());
            dto.updateEventName("PAYMENT_FAILED");
            producerService.sendMessage("order-event-topic", dto);
        }
    }
}