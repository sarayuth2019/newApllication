package com.example.Aplication.model.service;
import com.example.Aplication.model.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User ,Integer> {
    User findByEmail (String email);
    User findByEmailAndPassword (String email,String password);
}


