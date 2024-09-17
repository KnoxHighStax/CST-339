package com.gcu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Document(collection = "product")
public class Product 
{
	@Id
    private String id;
	
	@NotBlank
	@NotEmpty(message = "Product name is required!")
	private String name;
	
	@NotBlank
	@NotEmpty(message = "Description is required!")
	private String description;
	
	@DecimalMin(value = "0.1", inclusive = true, message = "Price must be greater than 0")
	private double price;
	
	// Getters and Setters
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
}
