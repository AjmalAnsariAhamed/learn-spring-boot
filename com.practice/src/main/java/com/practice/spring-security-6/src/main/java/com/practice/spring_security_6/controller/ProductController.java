package com.practice.spring_security_6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private record Product(Integer productId, String productName, double price) {
    }

    ;
    List<Product> products = new ArrayList<>(List.of(
            new Product(1, "iPhone", 999),
            new Product(2, "Mac Pro", 10999)
    ));

    @GetMapping()
    public List<Product> getProducts() {
        return products;
    }
    @PostMapping()
    public ResponseEntity<String> post(@RequestBody Product product){
        products.add(product);
        return ResponseEntity.ok("Okay");
    }


}

