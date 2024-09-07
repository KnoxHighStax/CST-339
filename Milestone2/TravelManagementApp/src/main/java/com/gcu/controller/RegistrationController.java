package com.gcu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.User;

@Controller
@RequestMapping("/register")
public class RegistrationController 
{
    @GetMapping
    public String showRegistration(Model model) 
    {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) 
    {
    	model.addAttribute("message", "User registered successfully!");
    	return "registration";	
    }
}
