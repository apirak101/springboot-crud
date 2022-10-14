package com.example.backend.service;

import com.example.backend.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product create(Product product);
    void delete(Long id);
}
