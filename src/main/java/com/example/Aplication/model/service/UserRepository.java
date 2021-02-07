package com.example.Aplication.model.service;

import com.example.Aplication.model.table.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername (String username);
    User findByUsernameAndPassword (String username,String password);
    List<User> findByName(String name);
    Optional<User> findById(Long id);
    /* Optional<User>findByUsername(String username); */
}


