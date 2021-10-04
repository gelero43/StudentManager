package com.example.studentmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanager.exception.UserNotFoundException;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.repository.StudentRepo;






@Service
public class StudentService {
	private final StudentRepo studentRepo;
	
	@Autowired
	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public Student addStudent(Student student) {
		student.setStudentCode(UUID.randomUUID().toString());
		return studentRepo.save(student);
	}
	
	public List<Student> findAllStudents(){
		return studentRepo.findAll();
	}
	
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void deleteStudent(Long id) {
		studentRepo.deleteStudentById(id);
	}
	
	public Student findStudentById(Long id) {
		return studentRepo.findStudentById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found"));
	}
}
