package com.modelsis.productservice.services.impl;

import com.modelsis.productservice.dto.ProductRequestDTO;
import com.modelsis.productservice.entities.Product;
import com.modelsis.productservice.entities.ProductType;
import com.modelsis.productservice.exceptions.EntityNotFoundException;
import com.modelsis.productservice.repositories.ProductDao;
import com.modelsis.productservice.repositories.ProductTypeDao;
import com.modelsis.productservice.services.IProductService;
import com.modelsis.productservice.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements IProductService
{
    private final ProductDao productDao;
    private final ProductTypeDao productTypeDao;
    private final ObjectsValidator<ProductRequestDTO> productRequestDTOValidator;
    @Override
    public Product save(ProductRequestDTO productRequestDTO)
    {
        log.info("Calling ProductService::save with param {}", productRequestDTO);
        productRequestDTOValidator.validate(productRequestDTO);
        ProductType productType = productTypeDao.findById(productRequestDTO.getType())
                .orElseThrow(()-> new EntityNotFoundException("Error"));
        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .productType(productType)
                .date(new Date())
                .build();
        return productDao.save(product);
    }

    @Override
    public Product update(Long id, ProductRequestDTO productRequestDTO)
    {
        log.info("Calling ProductService::update with param {} {}", id, productRequestDTO);
        productRequestDTOValidator.validate(productRequestDTO);

        Product product = this.findById(id);
        product.setName(productRequestDTO.getName());
        ProductType productType = productTypeDao.findById(productRequestDTO.getType())
                .orElseThrow(()-> new EntityNotFoundException("Error"));
        product.setProductType(productType);
        return productDao.save(product);
    }

    @Override
    public Product findById(Long id)
    {
        log.info("Calling ProductService::findById with param {}", id);

        return productDao.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Aucun product avec id = " + id));
    }

    @Override
    public List<Product> findAll()
    {
        log.info("Calling ProductService::findAll");
        return productDao.findAll();
    }
}
