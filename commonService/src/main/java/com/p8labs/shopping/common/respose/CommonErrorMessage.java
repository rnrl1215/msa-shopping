package com.p8labs.shopping.common.respose;

import org.springframework.http.HttpStatus;

public interface CommonErrorMessage {
    String getMessage();
    HttpStatus getHttpStatus();
    String getErrorCode();
}