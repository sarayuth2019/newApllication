package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Post;
import com.example.Aplication.model.table.User;

import org.springframework.data.jpa.repository.JpaRepository;


import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername (String username);
    public User findByUsernameAndPassword (String username,String password);
    List<User>  findByName(String name);
    Optional<User> findById(Long id);
    //public User findByName(String name);
    // Optional<User>findByUsername(String username);

}

