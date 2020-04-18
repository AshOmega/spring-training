package com.learning.service.impl;

import com.learning.model.Course;
import com.learning.repository.ICourseRepository;
import com.learning.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    ICourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourse() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void addAllCourses(List<Course> courseList) {
        courseRepository.saveAll(courseList);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
