package com.gcu.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements LoginService
{
	public boolean authenticate(String username, String password)
	{
		return "user".equals(username) && "password".equals(password);
	}
}
