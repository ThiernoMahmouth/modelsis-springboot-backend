package com.modelsis.productservice.repositories;

import com.modelsis.productservice.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeDao extends JpaRepository<ProductType, Long>
{
}
