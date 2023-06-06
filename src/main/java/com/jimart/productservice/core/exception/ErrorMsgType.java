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

    // product
    PRD_NOT_FOUND(NOT_FOUND, "해당 상품을 찾지 못했습니다."),

    // stock
    STOCK_NOT_ENOUGH(BAD_REQUEST, "해당 상품의 재고 수량이 부족합니다."),


    ;
    private final HttpStatus httpStatus;
    private final String message;
}
