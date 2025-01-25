package com.alpha.www.RestApis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PostMapping("/student/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		System.out.println(student);
		return student;
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	@DeleteMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		System.out.println(id);
		return (id <= 10) ? "Student successfully deleted with id: " + id : "Student not found with id: " + id;
	}
}
