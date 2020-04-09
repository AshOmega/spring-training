package com.learning.controllers;

import com.learning.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/getName")
    public String getName(){

        Student student = new Student(1, "Student1", 80.0);
        return student.getName();
    }
}
