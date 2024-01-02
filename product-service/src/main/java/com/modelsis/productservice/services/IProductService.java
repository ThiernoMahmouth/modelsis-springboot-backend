package com.modelsis.productservice.services;

import com.modelsis.productservice.dto.ProductRequestDTO;
import com.modelsis.productservice.entities.Product;

import java.util.List;

public interface IProductService
{
    Product save(ProductRequestDTO productRequestDTO);

    Product update(Long id, ProductRequestDTO productRequestDTO);

    Product findById(Long id);
    List<Product> findAll();

}
