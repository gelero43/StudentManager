package com.example.studentmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanager.model.Student;





public interface StudentRepo extends JpaRepository<Student,Long> {

	void deleteStudentById(Long id);
	Optional<Student> findStudentById(Long id);
	
}
