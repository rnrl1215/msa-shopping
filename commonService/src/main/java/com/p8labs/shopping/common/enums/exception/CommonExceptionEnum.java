package com.p8labs.shopping.common.enums.exception;

import com.p8labs.shopping.common.respose.CommonErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public enum CommonExceptionEnum implements CommonErrorMessage {
    ERROR("관리자에게 연락 주세요",
                                HttpStatus.INTERNAL_SERVER_ERROR,
                      "ERR-COMMON-001");

    private final String message;
    private final HttpStatus httpStatus;
    private final String errorCode;

    CommonExceptionEnum(String message,
                        HttpStatus httpStatus,
                        String errorCode) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }
}
