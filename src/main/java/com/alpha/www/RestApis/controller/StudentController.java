package com.alpha.www.RestApis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.RestApis.bean.Student;

@RestController
public class StudentController {

	@GetMapping("/student")
	public Student getStudent() {
		return new Student(1, "tom", "sharma");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "tom", "sharma"));
		students.add(new Student(2, "jerry", "agrawal"));
		students.add(new Student(3, "john", "cena"));
		students.add(new Student(4, "abc", "xyz"));
		return students;
	}
	
	@GetMapping("/student/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(
			@PathVariable("id") int studentId, 
			@PathVariable("first-name") String firstName, 
			@PathVariable("last-name") String lastName) {
		return new Student(studentId, firstName, lastName);
	}
	
	// localhost:8080/student/query?id=1&firstName=tom&lastName=sharma
	@GetMapping("/student/query")
	public Student studentQueryParameter(
			@RequestParam int id, 
			@RequestParam String firstName,
			@RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}
}
