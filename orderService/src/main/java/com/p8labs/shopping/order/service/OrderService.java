package com.p8labs.shopping.order.service;

import com.p8labs.shopping.order.dto.ProductDto;
import java.util.*;

public interface OrderService {
    Long save(Long userSeq, List<ProductDto> orderProducts);
}