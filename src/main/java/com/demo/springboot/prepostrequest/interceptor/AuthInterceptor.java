package com.demo.springboot.prepostrequest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor to authenticate requests.
 * 
 * @author Vijesh Kirodian
 *
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getHeader("authtoken") == null || !request.getHeader("authtoken").equals("12345678")) {
			//throw new AuthenticationException();
		}
		return true;
	}

}
