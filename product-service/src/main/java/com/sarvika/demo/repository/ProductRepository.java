package com.sarvika.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sarvika.demo.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByName(String name);
}

