package com.netcracker.edu.backend2.service.impl;

import com.netcracker.edu.backend2.entities.ProductsEntity;
import com.netcracker.edu.backend2.repository.ProductRepository;
import com.netcracker.edu.backend2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductsEntity> findAll() {
        return (List<ProductsEntity>) productRepository.findAll();
    }

    @Override
    public ProductsEntity save(ProductsEntity product) {
        return productRepository.save(product);
    }

    @Override
    public Page<ProductsEntity> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public ProductsEntity getProductById(int id) {
        return productRepository.getProductsEntitiesByProductId(id);
    }

    @Override
    public List<ProductsEntity> findProductsStartingWith(String str) {
        return productRepository.findProductsEntitiesByNameStartingWith(str);
    }
}

