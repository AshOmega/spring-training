package com.learning.repository;


import com.learning.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserAuthRepository extends CrudRepository<User, Long> {
    <S extends User> S save(S s);

    <S extends User> Iterable<S> saveAll(Iterable<S> iterable);

    Optional<User> findById(Long Long);

    boolean existsById(Long Long);

    Iterable<User> findAll();

    long count();

    void deleteById(Long Long);

    void deleteAll(Iterable<? extends User> iterable);

    User findByUsername(String username);

    User findByRole(String username);
}
