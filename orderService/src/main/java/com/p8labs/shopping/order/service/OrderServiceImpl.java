package com.p8labs.shopping.order.service;

import com.p8labs.shopping.order.dto.ProductDto;
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
        return 1L;
    }
}