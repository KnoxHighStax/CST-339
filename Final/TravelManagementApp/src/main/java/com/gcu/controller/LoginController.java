package com.gcu.controller;

import com.gcu.model.User;
import com.gcu.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController 
{

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String showLogin(@RequestParam(value = "error", required = false) String error, Model model) 
    {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password.");
        }
        return "login";
    }

    @PostMapping
    public ModelAndView loginUser(@ModelAttribute User user) 
    {
        if (loginService.authenticate(user.getUsername(), user.getPassword())) {
            return new ModelAndView("redirect:/", "username", user.getUsername());
        } else {
            return new ModelAndView("login", "error", "Invalid username or password.");
        }
    }
}
