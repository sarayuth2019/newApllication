package com.example.Aplication.model.service;

import com.example.Aplication.model.table.User;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User ,Integer> {
    User findByEmail (String email);
    User findByEmailAndPassword (String email,String password);
    Optional<User> findById(int id);

}


