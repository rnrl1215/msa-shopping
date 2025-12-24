package com.p8labs.shopping.order.enums;

import com.p8labs.shopping.common.response.CommonErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum OrderExceptionEnum implements CommonErrorMessage {
    ORDER_REQUEST_FAIL("주문서 생성 실패",
                                HttpStatus.INTERNAL_SERVER_ERROR,
                      "ERR-ORDER-001");

    private final String message;
    private final HttpStatus httpStatus;
    private final String errorCode;
}
