package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @postconstruct to load student data...only once when this given bean is constructed
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Aditya","Anasane"));
		theStudents.add(new Student("Marco","Reus"));
		theStudents.add(new Student("Lionel","Messi"));
	}
	
	//define endpoint for /students - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		
		
		
		return theStudents;
	}
	
	//define endpoint for "/students/{studentId}"--return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//check studentId list against list size
		if((studentId>=theStudents.size()) || (studentId<0)) {
			throw new StudentNotFoundException("Student with id:- "+ studentId + " not found!");
		}
		return theStudents.get(studentId);
	}
	
	
}
