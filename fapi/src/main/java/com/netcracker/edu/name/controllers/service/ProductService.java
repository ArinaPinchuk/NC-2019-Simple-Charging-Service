package com.netcracker.edu.name.controllers.service;

import com.netcracker.edu.name.controllers.models.ProductsEntity;
import com.netcracker.edu.name.controllers.models.RoleEntity;

import java.util.List;

public interface ProductService {
    List<ProductsEntity> findAll();
    ProductsEntity save(ProductsEntity product);
}
