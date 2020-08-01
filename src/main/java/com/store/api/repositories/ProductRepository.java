package com.store.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.store.api.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {}