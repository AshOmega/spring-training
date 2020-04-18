package com.learning.controllers;

import com.learning.model.Course;
import com.learning.model.CourseType;
import com.learning.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @GetMapping("/getName")
    public String getName(){
        Course Course = new Course(1L, "Course1", CourseType.FULLTIME, 100.0);
        return Course.getName();
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
    }
}
