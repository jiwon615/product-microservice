package com.jimart.productservice.domain.product.dto;

import com.jimart.productservice.domain.product.constant.ProductStatus;
import com.jimart.productservice.domain.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResDto {

    private Long id;
    private String categoryCode;
    private ProductStatus status;
    private String name;
    private int price;
    private int quantity;
    private LocalDateTime createdDateTime;

    @Builder
    private ProductResDto(Long id, String categoryCode, ProductStatus status, String name, int price, int quantity, LocalDateTime createdDateTime) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.status = status;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.createdDateTime = createdDateTime;
    }

    public static ProductResDto of(Product product) {
        return ProductResDto.builder()
                .id(product.getId())
                .categoryCode(product.getCategoryCode())
                .status(product.getStatus())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
