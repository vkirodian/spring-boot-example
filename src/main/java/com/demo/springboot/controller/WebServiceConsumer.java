package com.demo.springboot.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Demo for Rest Template. This Web Service consumes our own students web
 * services defined in {@code WebServiceController}.
 * 
 * @author Vijesh Kirodian
 *
 */
@RestController
@RequestMapping("/cons")
public class WebServiceConsumer {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/students")
	public ResponseEntity<Object> getStudentsList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("authtoken", "12345678");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8081/student/students", HttpMethod.GET, entity, Object.class);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String createStudent() {
		Student student = new Student("3", "Croco Dile");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("authtoken", "12345678");
		HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);
		return restTemplate.exchange("http://localhost:8081/student/students", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	public String updateStudent() {
		Student student = new Student("2", "Marry Jane");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("authtoken", "12345678");
		HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);

		return restTemplate.exchange("http://localhost:8081/student/students/" + student.getId(), HttpMethod.PUT,
				entity, String.class).getBody();
	}

	@RequestMapping(value = "/students", method = RequestMethod.DELETE)
	public String deleteStudent() {
		String id = "3";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("authtoken", "12345678");

		HttpEntity<Student> entity = new HttpEntity<Student>(headers);

		return restTemplate
				.exchange("http://localhost:8081/student/students/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
}
