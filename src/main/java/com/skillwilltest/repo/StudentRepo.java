package com.skillwilltest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillwilltest.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	public List<Student> findByAgeLessThanEqual(int age);

}
