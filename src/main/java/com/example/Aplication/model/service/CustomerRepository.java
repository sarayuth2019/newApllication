package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail (String email);
    Customer findByEmailAndPassword (String email,String password);
}
