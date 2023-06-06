package com.jimart.productservice.domain.product.dto;

import com.jimart.productservice.domain.product.constant.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductCreateReqDto {

    @NotBlank(message = "상품 코드는 필수입니다.")
    private String categoryCode;

    @NotNull(message = "상품 상태값은 필수입니다.")
    private ProductStatus status;

    @NotBlank(message = "상품명은 필수입니다.")
    private String productName;

    @Positive(message = "상품 가격은 양수여야 합나다.")
    private int price;

    @Positive(message = "재고 수량은 양수여야 합나다.")
    private int quantity;

    public ProductDto toProductDto() {
        return ProductDto.builder()
                .categoryCode(categoryCode)
                .status(status)
                .name(productName)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
