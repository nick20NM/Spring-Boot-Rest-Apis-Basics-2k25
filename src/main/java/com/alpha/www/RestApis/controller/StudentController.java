package com.alpha.www.RestApis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
}
