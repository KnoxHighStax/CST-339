package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	// Bean to help configure an in-memory user details manager with a single user
    @Bean
    public UserDetailsService userDetailsService() 
    {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // Create a user with username "admin", "password" (encoded), and role "USER"
        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("USER").build());
        return manager;
    }

    // Bean to provide a password encoder using BCrypt hashing
    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

    // Bean to configure HTTP security settings
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http
        	// Disable CSRF protection for simplicity (not recommended for properties)
            .csrf().disable()
            .authorizeRequests()
            	// Require authentication for any request
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	// Custom login page
                .loginPage("/login")
                // Allow all users to access the login page
                .permitAll()
                .and()
            .logout()
            	// Allow all users to access the logout functionality
                .permitAll();
        // Build and return the security filter chain
        return http.build();
    }
}
