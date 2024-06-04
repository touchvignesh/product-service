package com.excoder.productservice.repository;

import com.excoder.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.createdDate > :date")
    List<Product> findByCreatedDateAfter(@Param("date") LocalDate createdDate);
}