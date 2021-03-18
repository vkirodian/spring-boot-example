package com.demo.springboot.prepostrequest.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * LocalizationInterceptor is a used to change the new Locale based on the value
 * of the language parameter added to a request.
 * 
 * @author Vijesh Kirodian
 *
 */
@Component
public class LocalizationInterceptor {

	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
}
