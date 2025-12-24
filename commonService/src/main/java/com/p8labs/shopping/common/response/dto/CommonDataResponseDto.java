package com.p8labs.shopping.common.response.dto;

import com.p8labs.shopping.common.enums.message.CommonResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class  CommonDataResponseDto<T> extends CommonResponseDto {
    private T data;

    public CommonDataResponseDto(T data) {
        super(HttpStatus.OK, CommonResponse.OK.getMessage());
        this.data = data;
    }
}
