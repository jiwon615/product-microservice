package com.jimart.productservice.domain.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-service")
@RequiredArgsConstructor
@Profile("!prod")
public class ProductTestController {

    private final Environment env;

    @GetMapping("/health_check")
    public String status() {
        return String.format("Product Service is Working on PORT %s", env.getProperty("local.server.port"));
    }
}
