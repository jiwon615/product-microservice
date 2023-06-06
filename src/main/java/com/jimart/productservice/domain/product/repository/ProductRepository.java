package com.jimart.productservice.domain.product.repository;

import com.jimart.productservice.domain.product.constant.ProductStatus;
import com.jimart.productservice.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllProductsByStatusIn(List<ProductStatus> productStatus);
    List<Product> findAllProductsByCategoryCodeIn(List<String> categoryCodes);

    Optional<Product> findProductByCategoryCode(String categoryCode);
}
