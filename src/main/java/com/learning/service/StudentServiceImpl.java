package com.learning.service;

import com.learning.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    private List<Student> list = new ArrayList<>();

    public StudentServiceImpl() {
        Student student1= new Student(1, "Student1", 80);
        Student student2= new Student(2, "Student2", 90);
        list.add(student1);
        list.add(student2);
    }

    @Override
    public List<Student> getAllStudentDetails() {
        return list;
    }

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }
}
