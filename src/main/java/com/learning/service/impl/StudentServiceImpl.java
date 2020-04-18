package com.learning.service.impl;

import com.learning.model.Student;
import com.learning.repository.ICourseRepository;
import com.learning.repository.IStudentRepository;
import com.learning.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudentDetails() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void addAllStudents(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
