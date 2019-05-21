package com.netcracker.edu.name.controllers.service;

import com.netcracker.edu.name.controllers.models.ProductsEntity;
import com.netcracker.edu.name.controllers.models.RoleEntity;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductsEntity> findAll();
    Page<ProductsEntity> findAll(int page);
    ProductsEntity findById(int id);
    List<ProductsEntity> startWith(String str);

}
