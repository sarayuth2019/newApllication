package com.powergroup.model.service;

import com.powergroup.model.table.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);

    Customer findByEmailAndPassword(String email, String password);
}
