package com.gcu.service;

import java.util.List;
import java.util.Optional;

import com.gcu.model.Product;

public interface ProductService 
{
	void createProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(String id);
}
