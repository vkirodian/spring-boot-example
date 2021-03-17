package com.demo.springboot.prepostrequest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logs the remote host and address details.
 * 
 * @author Vijesh Kirodian
 *
 */
@Component
public class RequesterDetailsLoggerFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(RequesterDetailsLoggerFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.info("Remote Host: {}", request.getRemoteHost());
		LOG.info("Remote Address: {}", request.getRemoteAddr());
		chain.doFilter(request, response);
	}

}
