package com.gcu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long>
{

}
