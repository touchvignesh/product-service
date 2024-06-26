package com.excoder.productservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    private String name;
    private String description;
    private BigDecimal price;

    @Column(name = "created_at")
    private LocalDate createdDate;
}
