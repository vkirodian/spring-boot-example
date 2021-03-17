package com.demo.springboot.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.springboot.exception.AuthenticationException;
import com.demo.springboot.exception.InvalidStudentIdException;
import com.demo.springboot.exception.StudentNotFoundException;

/**
 * Controller Advice to handle custom exceptions thrown.
 * 
 * @author Vijesh Kirodian
 *
 */
@ControllerAdvice
public class WebServiceTestExceptionController {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNotFoundException exception) {
		return new ResponseEntity<>("Student not found for given ID", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidStudentIdException.class)
	public ResponseEntity<Object> exception(InvalidStudentIdException exception) {
		return new ResponseEntity<>("Student Id provided is invalid", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = AuthenticationException.class)
	public ResponseEntity<Object> exception(AuthenticationException exception) {
		return new ResponseEntity<>("Authentication error", HttpStatus.FORBIDDEN);
	}
}
