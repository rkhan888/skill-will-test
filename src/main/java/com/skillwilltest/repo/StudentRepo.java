package com.skillwilltest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillwilltest.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
