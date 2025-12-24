package com.p8labs.shopping.common.exception;

import com.p8labs.shopping.common.response.CommonErrorMessage;
import lombok.Getter;

@Getter
public class CommonServiceException extends RuntimeException {
    private final CommonErrorMessage commonErrorMessage;
    private String errorDetailMessage;

    public CommonServiceException(CommonErrorMessage commonErrorMessage) {
        super(commonErrorMessage.getMessage());
        this.commonErrorMessage = commonErrorMessage;
    }

    public CommonServiceException(CommonErrorMessage commonErrorMessage, String errorDetailMessage) {
        super(commonErrorMessage.getMessage());
        this.commonErrorMessage = commonErrorMessage;
        this.errorDetailMessage = errorDetailMessage;
    }
}
