package com.jimart.productservice.domain.product.controller;

import com.jimart.productservice.core.common.ApiResponse;
import com.jimart.productservice.domain.product.dto.ProductCreateReqDto;
import com.jimart.productservice.domain.product.dto.ProductResDto;
import com.jimart.productservice.domain.product.dto.ProductUpdateReqDto;
import com.jimart.productservice.domain.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-service/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ApiResponse<List<ProductResDto>> getAllProducts() {
        return ApiResponse.ok(productService.getAllProducts());
    }

    @GetMapping("display")
    public ApiResponse<List<ProductResDto>> getProductsForDisplay() {
        return ApiResponse.ok(productService.getProductsForDisplay());
    }

    @PostMapping("")
    public ApiResponse<ProductResDto> saveProduct(@RequestBody @Valid ProductCreateReqDto request) {
        return ApiResponse.created(productService.saveProduct(request.toProductDto()));
    }

    @PutMapping("")
    public ApiResponse<Void> updateProduct(@RequestBody ProductUpdateReqDto request) {
        productService.updateProduct(request.toProductDto());
        return ApiResponse.ok();
    }

    @DeleteMapping("{productId}")
    public ApiResponse<Void> deleteProductById(@PathVariable(name = "productId") Long productId) {
        productService.deleteProductById(productId);
        return ApiResponse.ok();
    }
}
