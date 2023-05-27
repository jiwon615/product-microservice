package com.jimart.productservice.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorMsgType {

    // common
    COMMON_SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다."),


    ;
    private final HttpStatus httpStatus;
    private final String message;
}
