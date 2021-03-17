package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springboot.model.Student;
import com.demo.springboot.service.WebService;

/**
 * Controller for ThymeLeaf implementation.
 * 
 * @author Vijesh Kirodian
 *
 */
@Controller
@RequestMapping(value = "/tl")
public class ThymeLeafController {

	@Autowired
	WebService webService;

	@GetMapping("/signup")
	public String showSignUpForm(Student student) {
		return "add-student";
	}

	@PostMapping("/addStudent")
	public String addUser(Student student, BindingResult result, Model model) {
		webService.createStudent(student);
		return "redirect:/tl/index";
	}

	@GetMapping("/index")
	public String getStudents(Model model) {
		model.addAttribute("students", webService.getStudents());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
		Student student = webService.getStudent(id);
		model.addAttribute("student", student);
		return "update-student";
	}

	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable("id") String id, Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		webService.createStudent(student);
		return "redirect:/tl/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") String id, Model model) {
		webService.deleteStudent(id);
		return "redirect:/tl/index";
	}
}
