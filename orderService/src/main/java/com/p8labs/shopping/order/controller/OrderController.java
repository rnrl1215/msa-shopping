package com.p8labs.shopping.order.controller;

import com.p8labs.shopping.common.response.dto.CommonDataResponseDto;
import com.p8labs.shopping.common.response.dto.CommonResponseDto;
import com.p8labs.shopping.order.dto.request.OrderRequest;
import com.p8labs.shopping.order.dto.response.OrderResponse;
import com.p8labs.shopping.order.service.OrderOrchestrationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderOrchestrationServiceImpl orderOrchestrationService;

    @PostMapping
    public ResponseEntity<CommonResponseDto> orderProducts(
            @RequestBody OrderRequest orderRequest
    ) {
        Long userSeq = orderRequest.getUserSeq();
        List<Long> productIds = orderRequest.getProductIds();
        Long orderId = orderOrchestrationService.createOrder(userSeq, productIds);

        OrderResponse orderResponse = new OrderResponse(orderId);
        return ResponseEntity.ok(new CommonDataResponseDto<>(orderResponse));
    }
}
