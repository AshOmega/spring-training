package com.learning.repository;

import com.learning.model.CourseEnrollment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICourseEnrollmentRepository extends CrudRepository<CourseEnrollment, Long> {

    <S extends CourseEnrollment> S save(S entity);

    <S extends CourseEnrollment> Iterable<S> saveAll(Iterable<S> entities);

    Optional<CourseEnrollment> findById(Long id);

    Optional<CourseEnrollment> findByStudentId(Long studentId);

    Optional<CourseEnrollment> findByCourseId(Long courseId);

    boolean existsById(Long id);

    Iterable<CourseEnrollment> findAll();

    Iterable<CourseEnrollment> findAllById(Iterable<Long> ids);

    @Query(value = "Select * from course_enrollment ce where ce.student_id = ?1", nativeQuery = true)
    Iterable<CourseEnrollment> findAllByStudentId(Long studentId);

    @Query(value = "Select * from course_enrollment ce where ce.course_id = ?1", nativeQuery = true)
    Iterable<CourseEnrollment> findAllByCourseId(Long courseId);

    long count();

    void deleteById(Long id);

    void delete(CourseEnrollment entity);

    void deleteAll(Iterable<? extends CourseEnrollment> entities);

    void deleteAll();
}
