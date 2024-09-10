package com.gcu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.gcu.model.Product;

@Service
public class ProductServiceImplement implements ProductService  
{
    private List<Product> products = new ArrayList<>();

    @Override
    public void createProduct(Product product) 
    {
        products.add(product);
        System.out.println("Product created: " + product.getName());
    }

    @Override
    public List<Product> getAllProducts() 
    {
        return products;
    }
}

