package com.gcu.service;

import com.gcu.model.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService 
{
    private final Map<String, User> users = new HashMap<>();

    public void registerUser(User user) 
    {
    	System.out.println("Registering user: " + user.getUsername());
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) 
    {
    	User user = users.get(username);
    	System.out.println("Retrieved user data: " + user);
        return user;
    }
}
