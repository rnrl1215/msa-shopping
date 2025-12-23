package com.p8labs.shopping.common.respose.dto;

import com.p8labs.shopping.common.enums.message.CommonResponse;
import com.p8labs.shopping.common.respose.CommonErrorMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonErrorResponseDto extends CommonResponseDto {
    private String errorCode;

    public CommonErrorResponseDto(CommonErrorMessage commonErrorMessage) {
        super(commonErrorMessage.getHttpStatus(), commonErrorMessage.getMessage());
        this.errorCode = commonErrorMessage.getErrorCode();
    }

    public CommonErrorResponseDto(HttpStatus code, String message, String errorCode) {
        super(code, message);
        this.errorCode = errorCode;
    }
}
