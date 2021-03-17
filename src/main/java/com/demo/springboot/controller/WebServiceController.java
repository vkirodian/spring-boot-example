package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.exception.InvalidStudentIdException;
import com.demo.springboot.model.Student;
import com.demo.springboot.service.WebService;

/**
 * Here we will test GET/POST/PUT/DELETE methods using Rest APIs.
 * 
 * @author Vijesh Kirodian
 *
 */
@RestController
@RequestMapping(value = "/student")
public class WebServiceController {

	@Autowired
	WebService webService;

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		webService.deleteStudent(id);
		return new ResponseEntity<>("Student is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
		webService.updateStudent(id, student);
		return new ResponseEntity<>("Student is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		if (Integer.parseInt(student.getId()) < 1) {
			throw new InvalidStudentIdException();
		}
		webService.createStudent(student);
		return new ResponseEntity<>("Student is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students")
	public ResponseEntity<Object> getStudent() {
		return new ResponseEntity<>(webService.getStudents(), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/byId")
	public ResponseEntity<Student> getStudentRP(
			@RequestParam(value = "id", defaultValue = "1", required = false) String id) {
		return new ResponseEntity<>(webService.getStudent(id), HttpStatus.OK);
	}
}