package com.p8labs.shopping.shipping.mq.kafka;

import com.p8labs.shopping.common.enums.eventtype.CommonOrderType;
import com.p8labs.shopping.common.kafka.dto.ShippingEventDto;
import com.p8labs.shopping.common.kafka.dto.ShoppingEventDto;
import com.p8labs.shopping.shipping.service.ShippingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConsumerService {

    private final ProducerService producerService;
    private final ShippingService shippingService;

    @KafkaListener(topics = "shipment-event-topic", groupId = "pay-event-process")
    public void consumeOfPayEvent(ShoppingEventDto dto) {

        log.info("배송 서비스 수신된 메시지: {}", dto);
        try {
            if (dto instanceof ShippingEventDto shoppingEventDto) {
                if (dto.getEventName().equalsIgnoreCase(CommonOrderType.ORDER_COMPLETED.name())) {
                    String shippingTrId = shippingService.requestShipping(shoppingEventDto);
                    log.info("Shipping tr id: {}", shippingTrId);
                }
            }
        } catch (Exception e) {
            log.error("배송 실패: {}", e.getMessage());
            dto.updateEventName("SHIPMENT_REQUEST_FAILED");
            producerService.sendMessage("order-event-topic", dto);
        }
    }
}