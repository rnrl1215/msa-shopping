package com.p8labs.shopping.common.errorhandler;

import com.p8labs.shopping.common.enums.exception.CommonExceptionEnum;
import com.p8labs.shopping.common.exception.CommonServiceException;
import com.p8labs.shopping.common.response.CommonErrorMessage;
import com.p8labs.shopping.common.response.dto.CommonErrorResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CommonErrorHandler {


    @ExceptionHandler({CommonServiceException.class})
    public ResponseEntity<CommonErrorResponseDto> handleCommonServiceException(CommonServiceException ex) {
        log.warn(ex.getMessage(), ex);

        if (StringUtils.hasText(ex.getErrorDetailMessage())) {
            log.error("Detail Error Message : {}", ex.getErrorDetailMessage(), ex);
        }

        CommonErrorMessage commonErrorMessage = ex.getCommonErrorMessage();

        return ResponseEntity.status(commonErrorMessage.getHttpStatus())
                .body(new CommonErrorResponseDto(commonErrorMessage));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<CommonErrorResponseDto> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        log.error("Validation Exception: {}", ex.getMessage());
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new CommonErrorResponseDto(ex.getStatusCode(), ex.getMessage() ,""));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CommonErrorResponseDto> handleAll(Exception ex) {
        log.error(ex.getMessage(), ex);

        return ResponseEntity.status(CommonExceptionEnum.ERROR.getHttpStatus())
                .body(new CommonErrorResponseDto(CommonExceptionEnum.ERROR));
    }
}