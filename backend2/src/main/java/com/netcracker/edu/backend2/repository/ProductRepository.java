package com.netcracker.edu.backend2.repository;

import com.netcracker.edu.backend2.entities.ProductsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductsEntity, Long> {
}