package com.example.Aplication.model.service;

import com.example.Aplication.model.table.User;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User ,Long> {
    User findByUsername (String username);
    User findByUsernameAndPassword (String username,String password);
    List<User> findByName(String name);
    Optional<User> findById(Long id);

}


