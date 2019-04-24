package com.netcracker.edu.name.controllers.controller;

import com.netcracker.edu.name.controllers.models.ProductsEntity;
import com.netcracker.edu.name.controllers.models.RoleEntity;
import com.netcracker.edu.name.controllers.service.ProductService;
import com.netcracker.edu.name.controllers.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductsEntity> getAllProducts(){
        List<ProductsEntity> list=productService.findAll();
        return productService.findAll();
    }
}
