package com.example.Aplication.model.service;

import com.example.Aplication.model.table.User;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername (String username);
    User findByUsernameAndPassword (String username,String password);
    User findByName(String name);
    Optional<User> findById(Long id);
    //public User findByName(String name);
    // Optional<User>findByUsername(String username);
}


