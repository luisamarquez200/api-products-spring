package com.api.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.products.model.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {

}
