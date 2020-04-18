package com.learning.controllers;

import com.learning.model.CourseEnrollment;
import com.learning.service.ICourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enroll")
public class CourseEnrollmentController {

    @Autowired
    ICourseEnrollmentService courseEnrollmentService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseEnrollment> getAllCourseEnrollments(){
        return courseEnrollmentService.getAllCourseEnrollment();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourseEnrollment(@Valid @RequestBody CourseEnrollment courseEnrollment){
        courseEnrollmentService.addCourseEnrollment(courseEnrollment);
    }
}
