package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements LoginService
{
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean authenticate(String username, String password)
	{
		try
		{
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return passwordEncoder.matches(password, userDetails.getPassword());
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
