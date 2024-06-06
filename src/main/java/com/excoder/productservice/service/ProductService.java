package com.excoder.productservice.service;

import com.excoder.productservice.model.Product;
import com.excoder.productservice.repository.ProductRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String productTopic;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        productRepository.save(product);
        var successMessage = kafkaTemplate.send(productTopic, product);
        successMessage.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                successMessage.completeExceptionally(exception);
            } else {
                successMessage.complete(sendResult);
            }
            log.info(String.valueOf(sendResult));
        });
        return product;
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByCreatedDateAfter(LocalDate createdDate) {
        return productRepository.findByCreatedDateAfter(createdDate);
    }
}
