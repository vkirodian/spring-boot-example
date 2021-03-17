package com.demo.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Contains all Rest related configurations.
 * 
 * @author Vijesh Kirodian
 *
 */
@Configuration
public class RestConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
