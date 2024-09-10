package com.gcu.service;

import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImplement implements RegistrationService 
{

    @Override
    public void registerUser(String firstName, String lastName, String email, String phoneNumber, String username, String password) 
    {
        System.out.println("User registered: " + username);
    }
}
