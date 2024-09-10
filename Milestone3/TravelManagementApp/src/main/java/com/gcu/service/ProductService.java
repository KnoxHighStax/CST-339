package com.gcu.service;

import java.util.List;

import com.gcu.model.Product;

public interface ProductService 
{
	void createProduct(Product product);
	List<Product> getAllProducts();
}
