package com.netcracker.edu.backend2.controllers;

import com.netcracker.edu.backend2.entities.ProductsEntity;
import com.netcracker.edu.backend2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProductsEntity> getAllProducts(){
        return productService.findAll();}
}
