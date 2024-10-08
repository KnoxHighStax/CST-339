package com.gcu.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>
{

	Optional<Product> findById(String id);

}
