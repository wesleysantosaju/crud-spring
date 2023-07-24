package com.crud.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudspring.model.Course;
import com.crud.crudspring.repository.CourseRepository;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public List<Course> list(){
		return courseRepository.findAll();
		
	}
	
	@PostMapping
	public ResponseEntity<Course> create(@RequestBody Course course) {
		return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
	}
}
