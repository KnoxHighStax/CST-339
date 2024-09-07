package com.gcu.controller;

import com.gcu.model.Login;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController 
{
    @GetMapping("")
    public String showLogin(Model model) 
    {
        model.addAttribute("title", "Login Form");
        model.addAttribute("login", new Login());
        
        return "login"; 
    }

    @PostMapping("/doLogin")
    public String loginUser(@Valid Login login, BindingResult result, Model model) 
    {
    	System.out.println(String.format("Form with username of %s and password of %s ", login.getUsername(), login.getPassword()));
    	
       if (result.hasErrors())
       {
    	   model.addAttribute("title", "Login Form");
    	   return "login";
       }
       return "/";
    }
}