package com.excoder.productservice.component;

import com.excoder.productservice.dto.ProductDTO;
import com.excoder.productservice.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDTO convertProductEntityToDto(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product convertProductDtoToEntity(ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDTO, Product.class);
    }
}
