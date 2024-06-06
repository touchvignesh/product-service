package com.excoder.productservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate createdDate;
}
