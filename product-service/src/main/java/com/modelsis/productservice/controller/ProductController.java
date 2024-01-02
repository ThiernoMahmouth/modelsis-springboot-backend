package com.modelsis.productservice.controller;

import com.modelsis.productservice.dto.ProductRequestDTO;
import com.modelsis.productservice.entities.Product;
import com.modelsis.productservice.services.IProductService;
import com.modelsis.productservice.services.IProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController
{
    private final IProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts()
    {
        return ResponseEntity
                .ok()
                .body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Long id)
    {
        return ResponseEntity
                .ok()
                .body(productService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductRequestDTO productRequestDTO)
    {
        return ResponseEntity
                .ok()
                .body(productService.save(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody ProductRequestDTO productRequestDTO)
    {
        return ResponseEntity
                .ok()
                .body(productService.update(id, productRequestDTO));
    }
}
