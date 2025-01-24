package com.alpha.www.RestApis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.RestApis.bean.Student;

@RestController
public class StudentController {

	@GetMapping("/student")
	public Student getStudent() {
		return new Student(1, "tom", "sharma");
	}
}
