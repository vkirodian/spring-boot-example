package com.demo.springboot.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.springboot.exception.StudentNotFoundException;
import com.demo.springboot.model.Student;

/**
 * Service class for our WebService controller.
 * 
 * @author Vijesh Kirodian
 *
 */
@Service
public class WebServiceImpl implements WebService {

	private static Map<String, Student> studentMap = new HashMap<>();
	static {
		Student johnDoe = new Student("1", "John Doe");
		studentMap.put(johnDoe.getId(), johnDoe);

		Student maryFoo = new Student("2", "Mary Foo");
		studentMap.put(maryFoo.getId(), maryFoo);
	}

	@Override
	public void deleteStudent(String id) {
		studentMap.remove(id);
	}

	@Override
	public void updateStudent(String id, Student student) {
		if (!studentMap.containsKey(id)) {
			throw new StudentNotFoundException("Student with ID" + id + " not found.");
		}
		studentMap.remove(id);
		student.setId(id);
		studentMap.put(id, student);
	}

	@Override
	public void createStudent(Student student) {
		studentMap.put(student.getId(), student);
	}

	@Override
	public Collection<Student> getStudents() {
		return studentMap.values();
	}

	@Override
	public Student getStudent(String id) {
		return studentMap.get(id);
	}
}
