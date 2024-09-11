package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig 
{
	// Bean to configure the Thymeleaf template engine
    @Bean
    public SpringTemplateEngine templateEngine() 
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // Set the template resolver to the template engine
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    // Bean to configure the template resolver for Thymeleaf
    @Bean
    public ITemplateResolver templateResolver() 
    {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        
        // Set the location of the template
        templateResolver.setPrefix("classpath:/templates/");
        
        // Set the suffix for template files
        templateResolver.setSuffix(".html");
        return templateResolver;
    }
}