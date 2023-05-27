package com.jimart.productservice.domain.product.service;

import com.jimart.productservice.domain.product.dto.ProductDto;
import com.jimart.productservice.domain.product.dto.ProductResDto;

import java.util.List;

public interface ProductService {

    // 전체 상품 목록 조회
    List<ProductResDto> getAllProducts();

    // display 되는 상품 목록 조회
    List<ProductResDto> getProductsForDisplay();

    // 신규 상품 등록
    ProductResDto saveProduct(ProductDto productDto);

    // 상품 정보 수정
    void updateProduct(ProductDto productDto);

    // 상품 삭제
    void deleteProductById(Long id);
}
