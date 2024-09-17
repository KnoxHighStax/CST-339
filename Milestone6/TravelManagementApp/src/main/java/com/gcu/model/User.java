package com.gcu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection = "users")
public class User 
{
	@Id
    private Long id;
	
	@NotBlank(message = "First Name is required!")
    private String firstName;
	
	@NotBlank(message = "Last Name is required!")
    private String lastName;
	
	@NotBlank(message = "Phone Number is required!")
    private String phoneNumber;
	
	@NotBlank(message = "Email is required!")
	@Email(message = "Invalid email format")
    private String email;
	
	@NotBlank(message = "Username is required!")
    private String username;
	
	@NotBlank(message = "Password is required!")
	@Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    // Getters and setters

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

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

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
}
