package com.gcu.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Document(collection = "user")
public class Login 
{
	@NotEmpty(message = "Username is required!")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	
	@NotEmpty(message = "Password is required!")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	// Getters and Setters
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username; 
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
