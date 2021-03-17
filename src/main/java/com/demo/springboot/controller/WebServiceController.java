package com.demo.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.exception.InvalidStudentIdException;
import com.demo.springboot.exception.StudentNotFoundException;

/**
 * Here we will test GET/POST/PUT/DELETE methods using Rest APIs.
 * 
 * @author Vijesh Kirodian
 *
 */
@RestController
@RequestMapping(value = "/student")
public class WebServiceController {

	private static Map<String, Student> studentMap = new HashMap<>();
	static {
		Student johnDoe = new Student("1","John Doe");
		studentMap.put(johnDoe.getId(), johnDoe);

		Student maryFoo = new Student("2","Mary Foo");
		studentMap.put(maryFoo.getId(), maryFoo);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		studentMap.remove(id);
		return new ResponseEntity<>("Student is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
		if (!studentMap.containsKey(id)) {
			throw new StudentNotFoundException("Student with ID" + id + " not found.");
		}
		studentMap.remove(id);
		student.setId(id);
		studentMap.put(id, student);
		return new ResponseEntity<>("Student is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		if (Integer.parseInt(student.getId()) < 1) {
			throw new InvalidStudentIdException();
		}
		studentMap.put(student.getId(), student);
		return new ResponseEntity<>("Student is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students")
	public ResponseEntity<Object> getStudent() {
		return new ResponseEntity<>(studentMap.values(), HttpStatus.OK);
	}

	@RequestMapping(value = "/students/byId")
	public ResponseEntity<Student> getStudentRP(
			@RequestParam(value = "id", defaultValue = "1", required = false) String id) {
		return new ResponseEntity<>(studentMap.get(id), HttpStatus.OK);
	}
}

class Student {
	private String id;
	private String name;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}