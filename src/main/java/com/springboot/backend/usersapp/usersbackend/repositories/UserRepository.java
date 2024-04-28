package com.springboot.backend.usersapp.usersbackend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.usersapp.usersbackend.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    Optional<User> findByUsername(String name);
}
