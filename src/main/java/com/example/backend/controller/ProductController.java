package com.example.backend.controller;

import com.example.backend.model.Product;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/FindAll")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
    return productService.create(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product product){
        product.setId(id);
        return productService.create(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
