package com.jimart.productservice.core.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jimart.productservice.domain.product.entity.Product;
import com.jimart.productservice.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// listener를 이용해 데이터를 가져오고, 가져온 값을 이용해 디비를 업데이트
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ProductRepository productRepository;

    @KafkaListener(topics = "example-product-topic")
    public void updateStock(String kafkaMessage) {
        log.info("Kafka Message: {}", kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 요청받은 상품 id로 상품 조회
        Optional<Product> productOpt = productRepository.findById((Long) map.get("productId"));

        // 해당 상품의 재고를 체크하여 요청 받은 갯수만큼 재고 감소 로직
        productOpt.ifPresent(p -> {
            // TODO: 로직 작성
        });
    }
}
