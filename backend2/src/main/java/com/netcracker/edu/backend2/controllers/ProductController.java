package com.netcracker.edu.backend2.controllers;

import com.netcracker.edu.backend2.entities.ProductsEntity;
import com.netcracker.edu.backend2.entities.UsersEntity;
import com.netcracker.edu.backend2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<ProductsEntity> getPage(@RequestParam(defaultValue = "0")int page) {
        PageRequest request=new PageRequest(page,2);
        return productService.findAll(request);
    }
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductsEntity getProductById(@PathVariable(name = "productId") int productId) {
        ProductsEntity product = productService.getProductById(productId);
        return product;
    }
    @GetMapping(value = "")
    public List<ProductsEntity> getProductsStartingWith(@RequestParam(required = false) String startWith) {
        if(StringUtils.isEmpty(startWith))
        {
            return productService.findAll();
        }
        else
        {
            return productService.findProductsStartingWith(startWith);
        }

    }

}
