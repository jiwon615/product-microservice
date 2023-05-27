package com.jimart.productservice.domain.product.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum ProductStatus {
    SELLING("판매중"),
    SOLD_OUT("품절"),
    HOLD("재입고 예정으로 인한 판매 보류"),
    STOP_SELLING("판매 중단");

    private final String text;

    public static List<ProductStatus> forDisplay() {
        return List.of(SELLING, HOLD);
    }
}
