package com.skillwilltest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillwilltest.model.Student;
import com.skillwilltest.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentDao;
	
	public List<Student> getStudents() {
		return studentDao.findAll();
	}
	
	public Student findStudentById(int id) {
		return studentDao.findById(id).orElse(null);		
	}
	
	public List<Student> findStudentByAgeLessThan(int age) {
		return studentDao.findByAgeLessThan(age);		
	}

}
