package com.learning.repository;

import com.learning.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICourseRepository extends CrudRepository<Course, Long> {

    <S extends Course> S save(S s);

    <S extends Course> Iterable<S> saveAll(Iterable<S> iterable);

    Optional<Course> findById(Long Long);

    boolean existsById(Long Long);

    Iterable<Course> findAll();

    long count();

    void deleteById(Long Long);

    void deleteAll(Iterable<? extends Course> iterable);

}
