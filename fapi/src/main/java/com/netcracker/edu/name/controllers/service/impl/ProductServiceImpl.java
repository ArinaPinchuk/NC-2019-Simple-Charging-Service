package com.netcracker.edu.name.controllers.service.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netcracker.edu.name.controllers.models.ProductsEntity;

import com.netcracker.edu.name.controllers.service.ProductService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

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
    public Page<ProductsEntity> findAll(int page) {
        RestTemplate restTemplate = new RestTemplate();
        RestPageImpl<ProductsEntity> productsResponse = restTemplate.getForObject(backendServerUrl +
                "/api/product/page?page="+ page , RestPageImpl.class);
        return productsResponse;
    }

    @Override
    public ProductsEntity findById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ProductsEntity productResponse = restTemplate.getForObject(backendServerUrl+"/api/product/"+id, ProductsEntity.class);
        return productResponse;
    }

    @Override
    public List<ProductsEntity> startWith(String str) {
        RestTemplate restTemplate = new RestTemplate();
        ProductsEntity[] productsResponse = restTemplate.getForObject(backendServerUrl + "/api/product?startWith="+ str, ProductsEntity[].class);
        return productsResponse == null ? Collections.emptyList() : Arrays.asList(productsResponse);
    }
}
class RestPageImpl<T> extends PageImpl<T>{

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestPageImpl(@JsonProperty("content") List<T> content,
                        @JsonProperty("number") int page,
                        @JsonProperty("size") int size,
                        @JsonProperty("totalElements") long total) {
        super(content, new PageRequest(page, size), total);
    }

    public RestPageImpl(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public RestPageImpl(List<T> content) {
        super(content);
    }

    public RestPageImpl() {
        super(new ArrayList());
    }
}

/*
class RestResponsePage<T> extends PageImpl<T> {

    private int number;
    private int size;
    private int totalPages;
    private int numberOfElements;
    private long totalElements;
    private boolean previousPage;
    private boolean first;
    private boolean nextPage;
    private boolean last;
    private List<T> content;
    private Sort sort;

    public RestResponsePage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public RestResponsePage(List<T> content) {
        super(content);
    }

    public RestResponsePage() {
        super(new ArrayList<T>());
    }

    public PageImpl<T> pageImpl() {
        return new PageImpl<T>(getContent(), new PageRequest(getNumber(),
                getSize(), getSort()), getTotalElements());
    }
}*/
