package com.jimart.productservice.core.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jimart.productservice.core.exception.CustomException;
import com.jimart.productservice.domain.product.entity.Product;
import com.jimart.productservice.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.jimart.productservice.core.exception.ErrorMsgType.PRD_NOT_FOUND;
import static com.jimart.productservice.core.exception.ErrorMsgType.STOCK_NOT_ENOUGH;

// listener를 이용해 데이터를 가져오고, 가져온 값을 이용해 디비를 업데이트
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ProductRepository productRepository;

    @KafkaListener(topics = "example-product-topic")
    public void updateStock(String kafkaMessage) {
        log.info("Kafka Message: {}", kafkaMessage);

//        Map<Object, Object> map = new HashMap<>();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            map = mapper.readValue(kafkaMessage, new TypeReference<>() {});
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        List<String> productIds = Arrays.asList(kafkaMessage.split(","));
        Map<String, Long> countsByProduct = createCountingMapBy(productIds);

        // 재고 차감 시도
        for (String id : new HashSet<>(productIds)) {
            Product product = productRepository.findById(Long.valueOf(id))
                    .orElseThrow(() -> new CustomException(PRD_NOT_FOUND));
            int reqQuantity = countsByProduct.get(id).intValue();
            if (product.isStockQuantityLessThan(reqQuantity)) {
                throw new CustomException(STOCK_NOT_ENOUGH);
            }
            product.setQuantity(product.getQuantity()-reqQuantity);
            productRepository.save(product);
        }
    }

    // 상품별 counting ex) "001": "2"
    private Map<String, Long> createCountingMapBy(List<String> productIds) {
        return productIds.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
    }
}
