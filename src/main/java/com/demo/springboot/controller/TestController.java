package com.demo.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic controller to check if application is working fine.
 * 
 * @author Vijesh Kirodian
 *
 */
@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

	@Value("${config.msg:Not_Working}")
	private String message;

	@Value("${config.name:NO_NAME}")
	private String name;

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

	@RequestMapping(value = "/configServerProps")
	public String loadPropertiesFromConfigServer() {
		return "Message:" + message + "--Name:" + name;
	}

}
