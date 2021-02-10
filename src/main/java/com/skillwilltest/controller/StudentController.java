package com.skillwilltest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillwilltest.model.Student;
import com.skillwilltest.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return service.getStudents();		
	}

}
