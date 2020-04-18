package com.learning.repository;

import com.learning.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IStudentRepository extends CrudRepository<Student, Long> {

    <S extends Student> S save(S s);

    <S extends Student> Iterable<S> saveAll(Iterable<S> iterable);

    Optional<Student> findById(Long Long);

    boolean existsById(Long Long);

    Iterable<Student> findAll();

    long count();

    void deleteById(Long Long);

    void deleteAll(Iterable<? extends Student> iterable);
}
