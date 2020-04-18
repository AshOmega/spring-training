package com.learning.service;

import com.learning.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseService {

    public Course getCourse(Long id);
    public List<Course> getAllCourse();
    public void addCourse(Course Course);
    public void addAllCourses(List<Course> CourseList);
    public void deleteCourse(Long id);
}
