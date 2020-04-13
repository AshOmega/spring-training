package com.learning.service;

import com.learning.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {

    public List<Student> getAllStudentDetails();
    public void addStudent(Student student);
}
