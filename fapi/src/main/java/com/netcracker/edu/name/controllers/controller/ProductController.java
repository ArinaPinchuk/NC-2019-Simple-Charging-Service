package com.netcracker.edu.name.controllers.controller;

import com.netcracker.edu.name.controllers.models.ProductsEntity;
import com.netcracker.edu.name.controllers.models.RoleEntity;
import com.netcracker.edu.name.controllers.models.SubscriptionsEntity;
import com.netcracker.edu.name.controllers.service.ProductService;
import com.netcracker.edu.name.controllers.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/page")
    public ResponseEntity<Page<ProductsEntity>> getPage(@RequestParam(defaultValue = "0")int page) {
        return ResponseEntity.ok(productService.findAll(page));
    }

}
