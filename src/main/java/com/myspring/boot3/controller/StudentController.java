package com.myspring.boot3.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;




@RestController
public class StudentController {


private String welcomeString = new String("Hello to --");


	@GetMapping("/students/{studentId}/")
	public String students(@PathVariable String studentId) {


		return welcomeString+studentId;
	}
	
	}

