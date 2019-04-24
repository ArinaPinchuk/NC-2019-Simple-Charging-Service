package com.netcracker.edu.backend2.service.impl;

import com.netcracker.edu.backend2.entities.ProductsEntity;
import com.netcracker.edu.backend2.repository.ProductRepository;
import com.netcracker.edu.backend2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}

