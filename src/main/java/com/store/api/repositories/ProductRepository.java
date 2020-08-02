package com.store.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.store.api.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {}