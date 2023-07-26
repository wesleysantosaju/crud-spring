package com.crud.crudspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudspring.model.Course;
import com.crud.crudspring.repository.CourseRepository;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	private List<Course> courses = new ArrayList<>();
	
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
	@DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        // Verifica se o curso existe no banco de dados
        if (!courseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Exclui o curso pelo id
        courseRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
	
}
