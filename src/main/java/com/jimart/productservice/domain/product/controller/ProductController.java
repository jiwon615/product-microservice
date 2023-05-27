package com.jimart.productservice.domain.product.controller;

import com.jimart.productservice.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-service/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


}
