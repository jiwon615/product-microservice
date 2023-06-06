package com.jimart.productservice.domain.product.entity;

import com.jimart.productservice.core.exception.CustomException;
import com.jimart.productservice.domain.common.BaseEntity;
import com.jimart.productservice.domain.product.constant.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import static com.jimart.productservice.core.exception.ErrorMsgType.STOCK_NOT_ENOUGH;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "jimart_product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(nullable = false)
    private String name;

    private int price;

    @Setter
    private int quantity;

    @Builder
    private Product(String categoryCode, ProductStatus status, String name, int price, int quantity) {
        this.categoryCode = categoryCode;
        this.status = status;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isStockQuantityLessThan(int reqQuantity) {
        return quantity < reqQuantity;
    }

    public void deductQuantity(int reqQuantity) {
        if (isStockQuantityLessThan(reqQuantity)) {
            throw new CustomException(STOCK_NOT_ENOUGH);
        }
        this.quantity -= reqQuantity;
    }
}