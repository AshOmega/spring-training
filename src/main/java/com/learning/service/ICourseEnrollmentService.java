package com.learning.service;

import com.learning.model.CourseEnrollment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseEnrollmentService {
    public CourseEnrollment getCourseEnrollmentByStudent(Long studentId);
    public CourseEnrollment getCourseEnrollmentByCourse(Long courseId);
    public List<CourseEnrollment> getAllCourseEnrollment();
    public void addCourseEnrollment(CourseEnrollment CourseEnrollment);
    public void addAllCourseEnrollments(List<CourseEnrollment> CourseEnrollmentList);
    public void deleteCourseEnrollmentByStudent(Long studentId);
}
