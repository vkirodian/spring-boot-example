package com.demo.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.demo.springboot.prepostrequest.interceptor.AuthInterceptor;
import com.demo.springboot.prepostrequest.interceptor.LocalizationInterceptor;

/**
 * Contains Interceptor related configurations.
 * 
 * @author Vijesh Kirodian
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor authInterceptor;

	@Autowired
	private LocalizationInterceptor localizationInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor);
		registry.addInterceptor(localizationInterceptor.localeChangeInterceptor());
	}

}
