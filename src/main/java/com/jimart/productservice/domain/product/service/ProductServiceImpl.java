package com.jimart.productservice.domain.product.service;

import com.jimart.productservice.core.exception.CustomException;
import com.jimart.productservice.domain.product.constant.ProductStatus;
import com.jimart.productservice.domain.product.dto.ProductDto;
import com.jimart.productservice.domain.product.dto.ProductResDto;
import com.jimart.productservice.domain.product.entity.Product;
import com.jimart.productservice.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jimart.productservice.core.exception.ErrorMsgType.PRD_NOT_FOUND;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductResDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductResDto::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public ProductResDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException(PRD_NOT_FOUND));
        return ProductResDto.of(product);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResDto> getProductsForDisplay() {
        List<Product> products = productRepository.findAllProductsByStatusIn(ProductStatus.forDisplay());
        return products.stream()
                .map(ProductResDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResDto saveProduct(ProductDto request) {
        Product product = request.toEntity();
        Product savedProduct = productRepository.save(product);
        return ProductResDto.of(savedProduct);
    }

    @Override
    public void updateProduct(ProductDto request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new CustomException(PRD_NOT_FOUND));
        product.setCategoryCode(request.getCategoryCode());
        product.setStatus(request.getStatus());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        productOpt.ifPresent(p -> productRepository.deleteById(p.getId()));
    }
}