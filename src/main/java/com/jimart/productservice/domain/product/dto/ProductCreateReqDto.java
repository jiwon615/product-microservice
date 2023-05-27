package com.jimart.productservice.domain.product.dto;

import com.jimart.productservice.domain.product.constant.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductCreateReqDto {

    @NotBlank(message = "상품 코드는 필수입니다.")
    private String categoryCode;

    @NotNull(message = "상품 상태값은 필수입니다.")
    private ProductStatus status;

    @NotBlank(message = "상품명은 필수입니다.")
    private String productName;

    @Positive(message = "상품 가격은 양수여야 합나다.")
    private int price;
}
