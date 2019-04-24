package com.netcracker.edu.name.controllers.service.impl;

import com.netcracker.edu.name.controllers.models.ProductsEntity;
import com.netcracker.edu.name.controllers.models.RoleEntity;
import com.netcracker.edu.name.controllers.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("ProductDetailsService")
public class ProductServiceImpl implements ProductService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public List<ProductsEntity> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ProductsEntity[] productsResponse = restTemplate.getForObject(backendServerUrl + "/api/product", ProductsEntity[].class);
        return productsResponse == null ? Collections.emptyList() : Arrays.asList(productsResponse);
    }
    @Override
    public ProductsEntity save(ProductsEntity productsEntity) {
        /*user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, User.class).getBody();*/
        return null;
    }
}
