package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springrest.springrest.services.CourseService;

import java.util.List;

@RestController
public class MyController
{

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String Home()
	{
		return "Welcome to courses application";
	}

	@GetMapping("/courses")
	public List<Course> getCourses()
	{

		return this.courseService.getCourses();
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}

	@PostMapping(path = "/courses", consumes = "application/json")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}

	@PutMapping(path = "/courses", consumes = "application/json")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}

	@DeleteMapping(path = "/courses/{courseId}")
	public Object deleteCourse(@PathVariable String courseId)
	{
		Object value = null;
		Course course = null;
		try
		{
			course = this.courseService.deleteCourse(Long.parseLong((courseId)));
		}
		catch (Exception e)
		{
			value = new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (value instanceof Exception)
		{
			return value;
		}
		else
		{
			return course;
		}
	}
}
