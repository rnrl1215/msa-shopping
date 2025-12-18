package com.p8labs.shopping.order.controller;

import com.p8labs.shopping.order.dto.OrderRequest;
import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.service.OrderOrchestrationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderOrchestrationServiceImpl orderOrchestrationService;

    @GetMapping
    public void orderProducts(
            @RequestBody OrderRequest orderRequest
    ) {

        Long userSeq = orderRequest.getUserSeq();
        List<Long> productIds = orderRequest.getProductIds();
        Long order = orderOrchestrationService.createOrder(userSeq, productIds);
    }
}
