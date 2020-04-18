package com.learning.service;

import com.learning.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {

    public Student getStudent(Long id);
    public List<Student> getAllStudentDetails();
    public void addStudent(Student student);
    public void addAllStudents(List<Student> studentList);
    public void deleteStudent(Long id);
}
