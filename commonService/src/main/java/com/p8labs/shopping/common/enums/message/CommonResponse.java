package com.p8labs.shopping.common.enums.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonResponse {
    OK("SUCCESS", HttpStatus.OK),
    FAIL("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    private final String message;
    private final HttpStatus status;
}
