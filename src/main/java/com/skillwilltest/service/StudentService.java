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

}
