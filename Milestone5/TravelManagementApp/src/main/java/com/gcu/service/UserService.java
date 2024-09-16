package com.gcu.service;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
	@Autowired
    private UserRepository userRepository;

    public void registerUser(User user) 
    {
    	userRepository.save(user);
    }

    public User getUser(String username) 
    {
    	return userRepository.findByUsername(username);
    }
}
