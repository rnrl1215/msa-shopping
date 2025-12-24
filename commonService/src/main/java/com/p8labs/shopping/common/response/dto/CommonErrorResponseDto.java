package com.p8labs.shopping.common.response.dto;

import com.p8labs.shopping.common.response.CommonErrorMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class CommonErrorResponseDto extends CommonResponseDto {
    private String errorCode;

    public CommonErrorResponseDto(CommonErrorMessage commonErrorMessage) {
        super(commonErrorMessage.getHttpStatus(), commonErrorMessage.getMessage());
        this.errorCode = commonErrorMessage.getErrorCode();
    }

    public CommonErrorResponseDto(HttpStatusCode code, String message, String errorCode) {
        super(code, message);
        this.errorCode = errorCode;
    }
}
