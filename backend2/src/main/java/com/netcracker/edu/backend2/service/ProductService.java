package com.netcracker.edu.backend2.service;

import com.netcracker.edu.backend2.entities.ProductsEntity;

import java.util.List;

public interface ProductService {
    List<ProductsEntity> findAll();
    ProductsEntity save(ProductsEntity user);
    void delete(long id);
}
