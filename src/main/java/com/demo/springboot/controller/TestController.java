package com.demo.springboot.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.service.EmailService;

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
	
	@Autowired
	private EmailService emailService;

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
	
	@RequestMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException {
		emailService.sendmail();
	   return "Email sent successfully";   
	}


}
