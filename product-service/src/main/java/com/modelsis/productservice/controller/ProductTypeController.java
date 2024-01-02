package com.modelsis.productservice.controller;

import com.modelsis.productservice.dto.ProductRequestDTO;
import com.modelsis.productservice.dto.ProductTypeRequestDTO;
import com.modelsis.productservice.entities.Product;
import com.modelsis.productservice.entities.ProductType;
import com.modelsis.productservice.services.IProductService;
import com.modelsis.productservice.services.IProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productType")
@RequiredArgsConstructor
public class ProductTypeController
{
    private final IProductTypeService productTypeService;
    @GetMapping
    public ResponseEntity<List<ProductType>> findAll()
    {
        return ResponseEntity
                .ok()
                .body(productTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductType> findById(@PathVariable("id") Long id)
    {
        return ResponseEntity
                .ok()
                .body(productTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductType> save(@RequestBody ProductTypeRequestDTO productRequestDTO)
    {
        return ResponseEntity
                .ok()
                .body(productTypeService.save(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductType> update(@PathVariable("id") Long id, @RequestBody ProductTypeRequestDTO productRequestDTO)
    {
        return ResponseEntity
                .ok()
                .body(productTypeService.update(id, productRequestDTO));
    }


}
