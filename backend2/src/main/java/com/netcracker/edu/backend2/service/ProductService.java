package com.netcracker.edu.backend2.service;

import com.netcracker.edu.backend2.entities.ProductsEntity;
import com.netcracker.edu.backend2.entities.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductsEntity> findAll();
    ProductsEntity save(ProductsEntity user);
    void delete(long id);
    Page<ProductsEntity> findAll(Pageable pageable);
}
