package com.p8labs.shopping.common.respose.dto;

import com.p8labs.shopping.common.enums.message.CommonResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponseDto {
    private int code;
    private String message;

    public CommonResponseDto(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }

    public static CommonResponseDto success() {
        return new CommonResponseDto(CommonResponse.OK.getStatus(), CommonResponse.OK.getMessage());
    }
}
