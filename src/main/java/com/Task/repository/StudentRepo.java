package com.Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task.MODEL.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	

}
