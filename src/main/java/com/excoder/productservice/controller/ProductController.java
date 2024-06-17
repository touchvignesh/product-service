package com.excoder.productservice.controller;

import com.excoder.productservice.component.ProductConverter;
import com.excoder.productservice.dto.ProductDTO;
import com.excoder.productservice.model.Product;
import com.excoder.productservice.service.ProductService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
// @CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    ProductConverter productConverter;

    @GetMapping("/list/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/list/id/{id}")
    public Optional<Product> findById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    // create a product
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping("/add")
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    // update a product
    @PutMapping("/update")
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    // delete a product
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @GetMapping("/list/name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping("/list/date-after/{date}")
    public List<Product> findByCreatedDateAfter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return productService.findByCreatedDateAfter(date);
    }
}
