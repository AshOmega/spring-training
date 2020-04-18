package com.learning.service.impl;

import com.learning.model.CourseEnrollment;
import com.learning.repository.ICourseEnrollmentRepository;
import com.learning.repository.ICourseRepository;
import com.learning.repository.IStudentRepository;
import com.learning.service.ICourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseEnrollmentServiceImpl implements ICourseEnrollmentService {

    @Autowired
    ICourseEnrollmentRepository courseEnrollmentRepository;

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public List<CourseEnrollment> getAllCourseEnrollment() {
        return (List<CourseEnrollment>) courseEnrollmentRepository.findAll();
    }

    @Override
    public void addCourseEnrollment(CourseEnrollment courseEnrollment) {
        List<CourseEnrollment> courseEnrollmentList;
        courseEnrollmentList = (List<CourseEnrollment>) findAllByStudentId(courseEnrollment.getStudentId());
        Optional<CourseEnrollment> courseEnrollmentFiltered = courseEnrollmentList.stream()
                .filter(e -> (e.getCourseId() == courseEnrollment.getCourseId() &&
                        e.getStudentId() == courseEnrollment.getStudentId())).findFirst();
        if (!courseEnrollmentFiltered.isPresent())
            courseEnrollmentRepository.save(courseEnrollment);
    }

    @Override
    public void addAllCourseEnrollments(List<CourseEnrollment> courseEnrollmentList) {
        courseEnrollmentRepository.saveAll(courseEnrollmentList);
    }


    @Override
    public void deleteCourseEnrollmentByStudent(Long studentId) {
        courseEnrollmentRepository.deleteById(studentId);
    }

    public Iterable<CourseEnrollment> findAllByStudentId(Long studentId) {
        return courseEnrollmentRepository.findAllByStudentId(studentId);
    }


    public Iterable<CourseEnrollment> findAllByCourseId(Long courseId) {
        return courseEnrollmentRepository.findAllByStudentId(courseId);
    }


    public CourseEnrollment getCourseEnrollmentByStudent(Long studentId) {
        return courseEnrollmentRepository.findByStudentId(studentId).get();
    }


    public CourseEnrollment getCourseEnrollmentByCourse(Long courseId) {
        return courseEnrollmentRepository.findByCourseId(courseId).get();
    }
}
