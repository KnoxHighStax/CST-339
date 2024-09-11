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
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
        )
        .formLogin(formLogin ->
            formLogin
                .loginPage("/login")
                .permitAll()
        )
        .logout(logout ->
            logout
                .permitAll()
        )
        .csrf(csrf -> csrf
        	// Disable CSRF protection if absolutely necessary; consider keeping it enabled for production
            .disable() 
        );
    return http.build();
    }
}
