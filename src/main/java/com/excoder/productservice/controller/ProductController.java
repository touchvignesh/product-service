package com.excoder.productservice.controller;

import com.excoder.productservice.model.Product;
import com.excoder.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping("/list/all")
    public List<Product> findAll() {
        return ProductService.findAll();
    }

    @GetMapping("/list/id/{id}")
    public Optional<Product> findById(@PathVariable Integer id) {
        return ProductService.findById(id);
    }

    // create a product
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping("/add")
    public Product create(@RequestBody Product product) {
        return ProductService.save(product);
    }

    // update a product
    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return ProductService.save(product);
    }

    // delete a product
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Integer id) {
        ProductService.deleteById(id);
    }

    @GetMapping("/list/name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return ProductService.findByName(name);
    }

    @GetMapping("/list/date-after/{date}")
    public List<Product> findByCreatedDateAfter(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ProductService.findByCreatedDateAfter(date);
    }

}
