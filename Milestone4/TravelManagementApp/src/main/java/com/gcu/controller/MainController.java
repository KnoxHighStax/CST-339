package com.gcu.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gcu.service.RegistrationService;

@Controller
public class MainController 
{

    private final RegistrationService registrationService;

    public MainController(RegistrationService registrationService) 
    {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String main() 
    {
        return "index";
    }

    @GetMapping("/products")
    public String products() 
    {
        return "products";
    }

    @GetMapping("/register")
    public String register() 
    {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String email,
                               @RequestParam String phoneNumber,
                               @RequestParam String username,
                               @RequestParam String password) 
    {
        registrationService.registerUser(firstName, lastName, email, phoneNumber, username, password);
        return "redirect:/";
    }
}
