package com.gcu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gcu.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
