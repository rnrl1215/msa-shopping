package com.p8labs.shopping.shipping.service;

import com.p8labs.shopping.common.kafka.dto.ShippingEventDto;
import com.p8labs.shopping.common.util.CryptoUtil;
import com.p8labs.shopping.shipping.mq.kafka.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShippingService {

    private final ProducerService producerService;

    public String requestShipping(ShippingEventDto shippingEventDto) {
        try {
            String shippingTrId = createShippingId(shippingEventDto.getOrderId(), shippingEventDto.getUserId());
            log.info("배송 요청 완료");
            shippingEventDto.updateEventName("SHIPMENT_REQUEST_COMPLETED");
            producerService.sendMessage( "order-event-topic", shippingEventDto);
            return shippingTrId;
        } catch (Exception e) {
            log.info("배송 요청 실패 {}", e.getMessage());
            throw e;
        }
    }

    public String createShippingId(Long orderId, Long userId) {
        String shippingTrId = UUID.randomUUID().toString();
        String rawId = shippingTrId.concat(orderId.toString()).concat(userId.toString());
        return CryptoUtil.encryptSha256(rawId);
    }
}
