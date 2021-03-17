package com.demo.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic controller to check if application is working fine.
 * 
 * @author Vijesh Kirodian
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {

	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World from Spring Boot Example Application";
	}

	@RequestMapping(value = "/testLogging")
	public String testLogging() {
		LOG.trace("This is a trace log");
		LOG.debug("This is a debug log");
		LOG.info("This is a info log");
		LOG.warn("This is a warn log");
		LOG.error("This is a error log");
		return "Check your logs";
	}

}
