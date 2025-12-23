package com.p8labs.shopping.order.service;

import com.p8labs.shopping.common.exception.CommonServiceException;
import com.p8labs.shopping.order.dto.ProductDto;
import com.p8labs.shopping.order.enums.OrderExceptionEnum;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Primary
@Service
public class OrderServiceImpl implements OrderService {

    @Transactional
    @Override
    public Long save(Long userSeq, List<ProductDto> orderProducts) {
        if (Math.random() < 0.5) {
            throw new IllegalArgumentException("주문 저장 실패");
        }
        return 1L;
    }
}