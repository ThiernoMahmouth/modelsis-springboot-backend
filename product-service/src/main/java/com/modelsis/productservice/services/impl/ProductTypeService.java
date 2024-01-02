package com.modelsis.productservice.services.impl;

import com.modelsis.productservice.dto.ProductRequestDTO;
import com.modelsis.productservice.dto.ProductTypeRequestDTO;
import com.modelsis.productservice.entities.Product;
import com.modelsis.productservice.entities.ProductType;
import com.modelsis.productservice.exceptions.EntityNotFoundException;
import com.modelsis.productservice.repositories.ProductDao;
import com.modelsis.productservice.repositories.ProductTypeDao;
import com.modelsis.productservice.services.IProductService;
import com.modelsis.productservice.services.IProductTypeService;
import com.modelsis.productservice.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductTypeService implements IProductTypeService
{
    private final ProductTypeDao productTypeDao;
    private final ObjectsValidator<ProductTypeRequestDTO> productRequestDTOValidator;
    @Override
    public ProductType save(ProductTypeRequestDTO productRequestDTO)
    {
        log.info("Calling ProductTypeService::save with param {}", productRequestDTO);
        productRequestDTOValidator.validate(productRequestDTO);

        ProductType productType = ProductType.builder()
                .name(productRequestDTO.getName())
                .date(new Date())
                .build();
        return productTypeDao.save(productType);
    }

    @Override
    public ProductType update(Long id, ProductTypeRequestDTO productRequestDTO)
    {
        log.info("Calling ProductTypeService::update with param {} {}", id, productRequestDTO);
        productRequestDTOValidator.validate(productRequestDTO);

        ProductType productType = this.findById(id);
        productType.setName(productType.getName());
        return productTypeDao.save(productType);
    }

    @Override
    public ProductType findById(Long id)
    {
        log.info("Calling ProductTypeService::findById with param {}", id);

        return productTypeDao.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Aucun type de product avec id = " + id));
    }

    @Override
    public List<ProductType> findAll()
    {
        log.info("Calling ProductTypeService::findAll");
        return productTypeDao.findAll();
    }
}
