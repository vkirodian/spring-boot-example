package com.demo.springboot.service;

import java.util.Collection;

import com.demo.springboot.model.Student;

public interface WebService {

	void deleteStudent(String id);

	void updateStudent(String id, Student student);

	void createStudent(Student student);

	Collection<Student> getStudents();

	Student getStudent(String id);
}
