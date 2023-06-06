package com.jimart.productservice.domain.product.dto;

import com.jimart.productservice.domain.product.constant.ProductStatus;
import com.jimart.productservice.domain.product.entity.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDto {

    private String categoryCode;
    private ProductStatus status;
    private String name;
    private int price;
    private int quantity;

    public Product toEntity() {
        return Product.builder()
                .categoryCode(categoryCode)
                .status(status)
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }

    @Builder
    private ProductDto(String categoryCode, ProductStatus status, String name, int price, int quantity) {
        this.categoryCode = categoryCode;
        this.status = status;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
