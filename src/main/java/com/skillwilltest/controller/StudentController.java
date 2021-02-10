package com.skillwilltest.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillwilltest.exception.StudentNotFoundException;
import com.skillwilltest.model.Student;
import com.skillwilltest.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
	
	private static final int AGE = 18;
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return service.getStudents();		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getbyId(@PathVariable int id) throws StudentNotFoundException {
		Student student = service.findStudentById(id);
		
		if(student == null) {
			throw new StudentNotFoundException("id " + id + " not found");
		} else {
			return ResponseEntity.ok(student);
		}
	}
	

	@GetMapping("/underAgeStudents")
	public ResponseEntity<List<Student>> underAge() {

		List<Student> students = service.findStudentByAgeLessThanEqual(AGE);

		if(!students.isEmpty()) {
			return ResponseEntity.ok(students);
		} else {
			throw new StudentNotFoundException("No students with age <= " + AGE);
		}
	}
	
	@GetMapping("/studentAgeLessThanEqual/{age}")
	public ResponseEntity<List<Student>> ageLessThan(@PathVariable int age) {
		List<Student> students = service.findStudentByAgeLessThanEqual(age);
		
		if(!students.isEmpty()) {
			return ResponseEntity.ok(students);
		} else {
			throw new StudentNotFoundException("No students with age less than " + age);
		}
		
	}

}
