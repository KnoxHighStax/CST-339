package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;

@Service
public class LoginServiceImplement implements LoginService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean authenticate(String username, String password)
	{
		User user = userRepository.findByUsername(username);
		return "user" != null && passwordEncoder.matches(password, user.getPassword());
	}
}
