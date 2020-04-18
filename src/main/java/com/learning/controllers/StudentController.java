package com.learning.controllers;

import com.learning.model.Student;
import com.learning.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/getName")
    public String getName(){
        Student student = new Student(1L, "Student1");
        return student.getName();
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){
        return studentService.getAllStudentDetails();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
    }
}
