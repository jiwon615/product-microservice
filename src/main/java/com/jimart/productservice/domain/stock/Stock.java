package com.jimart.productservice.domain.stock;

import com.jimart.productservice.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "jimart_stock")
public class Stock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    private String productCd;

    private int quantity;

    @Builder
    private Stock(String productCd, int quantity) {
        this.productCd = productCd;
        this.quantity = quantity;
    }
}
