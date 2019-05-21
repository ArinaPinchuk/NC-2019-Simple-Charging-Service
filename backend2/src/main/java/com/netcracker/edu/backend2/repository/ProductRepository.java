package com.netcracker.edu.backend2.repository;

import com.netcracker.edu.backend2.entities.ProductsEntity;
import com.netcracker.edu.backend2.entities.SubscriptionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductsEntity, Integer> {
    ProductsEntity getProductsEntitiesByProductId(int id);
    List<ProductsEntity> findProductsEntitiesByNameStartingWith(String str);
}