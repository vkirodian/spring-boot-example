package com.demo.springboot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Contains all Rest related configurations.
 * 
 * @author Vijesh Kirodian
 *
 */
@Configuration
public class RestConfig {

	@Value("${app.ssl:false}")
	private boolean appSsl;

	@Bean
	public RestTemplate getRestTemplate() {
		// TODO if appSsl is true, make Rest Template set SSL context.
		return new RestTemplate();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/student/**").allowedOrigins("http://localhost:8082");
			}
		};
	}
}
