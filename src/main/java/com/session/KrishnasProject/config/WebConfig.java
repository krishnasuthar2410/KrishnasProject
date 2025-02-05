package com.session.KrishnasProject.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	 

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        // Allow requests from your Angular frontend (localhost:4200)
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200") // Frontend URL (Angular app)
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP Methods
	                .allowedHeaders("*") // Allow any header
	                .allowCredentials(true); // Allow cookies or authentication
	    }
	}

