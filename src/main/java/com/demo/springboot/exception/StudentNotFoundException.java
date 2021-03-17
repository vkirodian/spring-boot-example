package com.demo.springboot.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8158309786365542182L;

	public StudentNotFoundException(String message) {
		super(message);
	}
}
