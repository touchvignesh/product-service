package com.excoder.productservice.service;

import com.excoder.productservice.model.Product;
import com.excoder.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String productTopic;

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll() {
        return ProductRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return ProductRepository.findById(id);
    }

    public Product save(Product product) {
        ProductRepository.save(product);
        var message_success = kafkaTemplate.send(productTopic, product);
        message_success.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                message_success.completeExceptionally(exception);
            } else {
                message_success.complete(sendResult);
            }
            System.out.println(sendResult);
        });
        return product;
    }

    public void deleteById(Integer id) {
        ProductRepository.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return ProductRepository.findByName(name);
    }

    public List<Product> findByCreatedDateAfter(LocalDate createdDate) {
        return ProductRepository.findByCreatedDateAfter(createdDate);
    }
}
