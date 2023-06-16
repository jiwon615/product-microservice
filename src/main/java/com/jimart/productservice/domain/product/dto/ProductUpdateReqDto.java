package com.jimart.productservice.domain.product.dto;

import com.jimart.productservice.domain.product.constant.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductUpdateReqDto {

    private Long id;
    private String categoryCode;
    private ProductStatus status;
    private String name;
    private int price;
    private int quantity;

    public ProductDto toProductDto() {
        return ProductDto.builder()
                .id(id)
                .categoryCode(categoryCode)
                .status(status)
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
