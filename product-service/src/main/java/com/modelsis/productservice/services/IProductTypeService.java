package com.modelsis.productservice.services;

import com.modelsis.productservice.dto.ProductRequestDTO;
import com.modelsis.productservice.dto.ProductTypeRequestDTO;
import com.modelsis.productservice.entities.Product;
import com.modelsis.productservice.entities.ProductType;

import java.util.List;

public interface IProductTypeService
{
    ProductType save(ProductTypeRequestDTO productTypeRequestDTO);

    ProductType update(Long id, ProductTypeRequestDTO productTypeRequestDTO);

    ProductType findById(Long id);
    List<ProductType> findAll();

}
