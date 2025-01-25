package com.alpha.www.RestApis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "tom", "sharma");
//		return ResponseEntity.ok(student);
//		return new ResponseEntity<>(student, HttpStatus.OK);
		return ResponseEntity
				.ok()
				.header("custom-header", "tom")
				.body(student);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "tom", "sharma"));
		students.add(new Student(2, "jerry", "agrawal"));
		students.add(new Student(3, "john", "cena"));
		students.add(new Student(4, "abc", "xyz"));
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/student/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVariable(
			@PathVariable("id") int studentId, 
			@PathVariable("first-name") String firstName, 
			@PathVariable("last-name") String lastName) {
		return ResponseEntity.ok(new Student(studentId, firstName, lastName));
	}
	
	// localhost:8080/student/query?id=1&firstName=tom&lastName=sharma
	@GetMapping("/student/query")
	public ResponseEntity<Student> studentQueryParameter(
			@RequestParam int id, 
			@RequestParam String firstName,
			@RequestParam String lastName) {
		return ResponseEntity.ok(new Student(id, firstName, lastName));
	}
	
	@PostMapping("/student/create")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		System.out.println(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@PutMapping("/student/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		System.out.println(id);
		return ResponseEntity.ok((id <= 10) ? "Student successfully deleted with id: " + id : "Student not found with id: " + id);
	}
}
