package com.demo.springboot.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.demo.springboot.model.Greeting;
import com.demo.springboot.model.UserDetails;

@Controller
public class WebSocketController {

	@MessageMapping("/mytopic")
	@SendTo("/topic/greetings")
	public Greeting greeting(UserDetails message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}
}
