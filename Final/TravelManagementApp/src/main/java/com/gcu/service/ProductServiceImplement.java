package com.gcu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.model.Product;
import com.gcu.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService  
{
	@Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) 
    {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() 
    {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) 
    {
        return productRepository.findById(id);
    }
}

