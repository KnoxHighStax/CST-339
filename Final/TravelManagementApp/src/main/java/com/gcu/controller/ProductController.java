package com.gcu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.Product;
import com.gcu.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{

    @Autowired
    private ProductService productService;

    // @GetMapping("/create")
    // public String showProductMakeForm(Model model) 
    // {
    //     model.addAttribute("product", new Product());
    //     return "createProduct";
    // }

    // @PostMapping("/create")
    // public String createProduct(@Valid @ModelAttribute Product product, BindingResult result) 
    // {
    //     if (result.hasErrors()) {
    //         return "createProduct";
    //     }
    //     productService.createProduct(product);
    //     return "redirect:/";
    // }
    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() 
    {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) 
    {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
