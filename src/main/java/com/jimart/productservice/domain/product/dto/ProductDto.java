package com.jimart.productservice.domain.product.dto;

import com.jimart.productservice.domain.product.constant.ProductStatus;
import com.jimart.productservice.domain.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductDto {

    private String categoryCode;
    private ProductStatus status;
    private String name;
    private int price;

    public Product toEntity() {
        return Product.builder()
                .categoryCode(categoryCode)
                .status(status)
                .name(name)
                .price(price)
                .build();
    }
}
