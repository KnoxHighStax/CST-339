package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.User;
import com.gcu.service.RegistrationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController 
{

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String showRegistration(User user) 
    {
        return "register";
    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "register";
        }
        registrationService.registerUser(
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getUsername(),
            user.getPassword()
        );
        return "redirect:/login";
    }
}
