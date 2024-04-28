package com.springboot.backend.usersapp.usersbackend.repositories;

import com.springboot.backend.usersapp.usersbackend.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
