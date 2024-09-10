package com.gcu.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService 
{
	boolean authenticate(String username, String password);
}
